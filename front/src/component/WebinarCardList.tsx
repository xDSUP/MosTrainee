import React, {Component} from "react";
import {WebinarCard} from "./WebinarCard";
import AxiosUtils from "../utils/AxiosUtils";
import {Activity} from "../dto/Activity";
import {Urls} from "../utils/Urls";
import {observer} from "mobx-react";
import {action, makeAutoObservable} from "mobx";

class WebinarCardListState {
    webinars: Activity[] = [];

    constructor() {
        makeAutoObservable(this);
    }

    @action
    setWebinars(webinars: Activity[]) {
        this.webinars = webinars;
    }
}

@observer
export class WebinarCardList extends Component<{}, WebinarCardListState> {
    state = new WebinarCardListState();
    componentDidMount() {
        AxiosUtils.get<Activity[]>(Urls.serverUrl + "/api/activity/all")
            .then(activities => {
                console.log(activities)
                this.state.setWebinars(activities as Activity[]);
            });
    }

    render() {
        return (
            <div className="mt-3">
                {
                    this.state.webinars
                        .filter(activity => activity.activityType === "WEBINAR")
                        .map(webinar => <WebinarCard key={webinar.id} activity={webinar}/>)
                }
            </div>
        );
    }
}