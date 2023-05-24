import {Component} from "react";
import "./css/countdownStage.css"
export class CountdownStage extends Component<{stageId: number, isActive: boolean}> {
    render() {
        return (
            <div className={`countdown-stage
            ${this.props.isActive ? "bg-red-600" : "bg-white opacity-20"}`}>
                {this.props.stageId}
            </div>
        );
    }
}