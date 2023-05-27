import React, {Component} from "react";
import {MainContent} from "./MainContent";
import {RightBlock} from "./RightBlock";

export class CenterPage extends Component {
    render() {
        return (
            <div className="flex mt-7 ml-72 ">
                <MainContent/>
                <RightBlock/>
            </div>
        );
    }
}