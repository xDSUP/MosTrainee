// @flow
import * as React from 'react';
import {Stage} from "../dto/Stage";
import AxiosUtils from "../utils/AxiosUtils";
import {Urls} from "../utils/Urls";
import {action, computed, makeAutoObservable} from "mobx";
import {observer} from 'mobx-react';
import {ReactComponent as Checked} from "../icons/checked.svg";
import {ReactComponent as Time} from "../icons/time.svg";
import {ReactComponent as Waiting} from "../icons/waiting.svg";
import {format, parseISO} from 'date-fns';
import {Activity} from "../dto/Activity";
import {ParticActivityHist} from "../dto/ParticActivityHist";
import {ru} from "date-fns/locale";
import {Button} from "./Button";

class CandidateProgressState {
    stages: Stage[] = [];
    activities: Activity[] = [];
    selectedStageId = 0;

    constructor() {
        makeAutoObservable(this);
    }

    @computed
    get selectedActivities() {
        return this.activities.filter(activity => activity.stageId === this.selectedStageId)
    }

    @action
    setSelectedStage(id: number) {
        console.log("setSelectedStage " + id)
        this.selectedStageId = id;
    }

    @action
    setStages(stages: Stage[]) {
        this.stages = stages;
        this.selectedStageId = stages.find(stage => stage.active)?.id || 0;
    }

    @action
    setActivities(activities: Activity[]) {
        this.activities = activities;
    }
};

function StageComponent(props: { stages: Array<Stage>, setSelectedStage: (id: number) => void }) {

    let activeStage = props.stages.findIndex(stage => stage.active)
    let activeStageText = "Конкурсный отбор стажёров";
    let progress = Math.floor((activeStage + 1) / props.stages.length * 100);

    return <div className={""}>
        <div className={"mb-2"}>
            <span className={"text-white text-2xl"}>{activeStageText}</span>
            <br/>
            <span className="text-white">{`${activeStage + 1}/${props.stages.length}`}</span>
            <div className="h-2 w-full rounded bg-neutral-200 dark:bg-neutral-600">
                <div className="h-2 rounded bg-white" style={{width: progress + "%"}}></div>
            </div>
        </div>
        <ul className="flex flex-col list-none gap-2" role="tablist" data-te-nav-ref>
            {props.stages.map(stage => {
                const ended = parseISO(stage.endDate) < new Date();
                let icon = stage.active ? <Time/> : ended ? <Checked/> : <Waiting/>;
                let textColor = stage.active || !ended ? "text-black" : "text-white"
                let strokeColor = stage.active || !ended ? "stroke-black" : "stroke-white"
                let bgColor = stage.active ? "bg-white" : ended ? "bg-red-700 border-transparent" : "bg-white opacity-75";
                return <li key={stage.id} role="presentation"
                           onClick={() => props.setSelectedStage(stage.id)}
                           className={`flex-grow ${bgColor} cursor-pointer border-2 rounded-lg flex items-center justify-between p-2`}>
                    <span className={`${textColor} text-xs`}>
                        {stage.description}
                    </span>
                    <i className={`${strokeColor}`}>
                        {icon}
                    </i>
                </li>
            })}
        </ul>
    </div>
}

function ActivityComponent(props: { activities: Array<Activity> }) {
    return <div className={"flex flex-col flex-wrap gap-4 grid grid-cols-8"}>
        {
            props.activities.map(activity => {
                let icon = activity.particActivity
                    ? <Checked/>
                    : <Time/>;
                let iconStyle = activity.particActivity ? "stroke-white bg-red-500" : "stroke-gray-600 bg-gray-300";

                return <div key={activity.id} className={"rounded bg-white p-4 col-span-4 h-[200]"}>
                    <div className={"flex flex-row justify-between "}>
                        <span className={"rounded bg-gray-300 p-1 pr-4 pl-4"}>{activity.activityType}</span>
                        <i className={`rounded p-1 ${iconStyle}`}>
                            {icon}
                        </i>
                    </div>
                    <span className={"text-xl"}>{activity.code}</span>
                    {
                        !activity.particActivity && <div className={"flex flex-row mt-2"}>
                            <Button className={"text-white"} type="button" text={"Перейти"}/>
                            <span className={"ml-1  place-self-center"}>
                                {"до " + format(parseISO(activity.endDateTime), 'd MMMM, eeee', {locale: ru})}
                            </span>
                        </div>
                    }
                    {
                        activity.particActivity && <div>
                            <span className={"text-sm text-gray-400"}>Результаты:</span>
                            <br/>
                            <span className={"pl-1 text-lg"}>{activity.particActivity.score + " баллов"}</span>
                        </div>
                    }
                </div>;
            })
        }
    </div>
}


@observer
export class CandidateProgress extends React.Component<{}> {
    state = new CandidateProgressState();

    componentDidMount() {
        AxiosUtils.get<Stage[]>(Urls.serverUrl + "/api/stage-schedule/candidate")
            .then(stages => {
                console.log(stages)
                this.state.setStages(stages as Stage[]);
            });
        AxiosUtils.get<Activity[]>(Urls.serverUrl + "/api/activity/all")
            .then(activities => {
                console.log(activities)
                if (!activities) return;
                this.state.setActivities(activities as Activity[]);
                return activities;
            })
            .then((activities) => {
                if (!activities) return;
                AxiosUtils.get<ParticActivityHist[]>(Urls.serverUrl + "/api/participant/my-activity")
                    .then(particActivities => {
                        console.log(particActivities)
                        if (!particActivities) return;
                        for (let activity of activities) {
                            activity.particActivity = particActivities.find(pa => pa.stageActivity.id === activity.id);
                        }
                        console.log(activities)
                        this.state.setActivities(activities);
                    });
            });


    }

    render() {
        return (
            <div className={"mb-4"}>
                <h1 className={"text-3xl font-bold pl-4"}>План развития</h1>
                <div className={"mx-auto grid grid-cols-12 gap-4 p-1"}>
                    <div className="rounded-lg border border-gray-500 bg-red-500 p-4 col-span-4">
                        <StageComponent stages={this.state.stages}
                                        setSelectedStage={(id) => this.state.setSelectedStage(id)}/>
                    </div>
                    <div className="rounded-lg col-span-8">
                        <ActivityComponent activities={this.state.selectedActivities}/>
                    </div>
                </div>
            </div>
        );
    };
};