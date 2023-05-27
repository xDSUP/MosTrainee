import React, {Component} from "react";
import "./css/fixed-right-block.css"
import {CurrentDateHeader} from "../component/CurrentDateHeader";
import {WebinarCardList} from "../component/WebinarCardList";

export class RightBlock extends Component {
    render() {
        return (
            <div className="fixed-right-block">
                <CurrentDateHeader/>
                <WebinarCardList/>
            </div>
        );
    }
}