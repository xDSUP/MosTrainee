import {Component} from "react";
import {CountdownStage} from "./CountdownStage";
import "./css/countdown.css"

export class Countdown extends Component<{stagesSize: number, activeStage: number}> {

    stages: number[] = []

    constructor(props: { stagesSize: number; activeStage: number }) {
        super(props);
        for (let i = 0; i < this.props.stagesSize; i++) {
            this.stages.push(i + 1);
        }
    }


    render() {
        return (
            <div className="countdown">
                {
                    this.stages.map((value) => (
                        <CountdownStage stageId={this.stages.length - value + 1} isActive={value <= this.props.activeStage}/>
                    ))
                }
            </div>
        );
    }
}