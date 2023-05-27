import React, {Component} from "react";
import {Activity} from "../dto/Activity";
import {format, parseISO} from "date-fns";
import {ru} from "date-fns/locale";
import {ReactComponent as Calendar} from "../icons/calendar.svg"
import {ReactComponent as Time} from "../icons/time.svg"
import {ReactComponent as Play} from "../icons/play.svg"

class WebinarCardState {

    header: string
    dateStart: string
    timeStart: string
    timeEnd: string
    link = ""
    isActiveNow = false;

    constructor(activity: Activity) {
        const startDateTime = parseISO(activity.startDateTime);
        const endDateTime = parseISO(activity.endDateTime);

        const currentDate = new Date();

        if (currentDate > startDateTime && currentDate < endDateTime)
        {
            this.isActiveNow = true;
        }
        this.link = activity.linkToExtResource;

        this.dateStart = format(startDateTime, 'd MMMM, eeee', { locale: ru });

        this.timeStart = format(startDateTime, 'HH:mm');
        this.timeEnd = format(parseISO(activity.endDateTime), 'HH:mm');

        this.header = activity.code
    }
}

export class WebinarCard extends Component<{activity: Activity}, WebinarCardState> {
    state = new WebinarCardState(this.props.activity);

    render() {
        return (
            <div className="border border-gray-300 p-3 rounded-[10px] my-3 flex flex-col text-left">
                <h1>Вебинар "{this.state.header}"</h1>

                <div className={`flex flex-row mt-2`}>
                    <div className="my-auto mr-2">
                        <Calendar className="stroke-black"/>
                    </div>
                    <span>{this.state.dateStart}</span>
                </div>

                <div className={`flex flex-row mb-2`}>
                    <div className="my-auto mr-2">
                        <Time className="stroke-black"/>
                    </div>
                    <span>{this.state.timeStart} - {this.state.timeEnd}</span>
                </div>

                <a href={this.state.link} className="text-violet-800">
                    <div className="border border-gray-300 p-2 flex flex-row justify-center rounded-[10px]">
                        <div className="my-auto mr-2">
                            <Play className="stroke-violet-800"/>
                        </div>
                        Открыть ссылку
                    </div>
                </a>

            </div>
        );
    }
}