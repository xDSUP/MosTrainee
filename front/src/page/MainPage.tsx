import React, {Component} from "react";
import {observer} from "mobx-react";
import {LeftMainMenu} from "./LeftMainMenu";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {CenterPage} from "./CenterPage";

@observer
export class MainPage extends Component {
    render() {
        return (
            <BrowserRouter>
                <LeftMainMenu/>

                <Routes>
                    <Route path="/center" element={<CenterPage/>} />
                </Routes>
            </BrowserRouter>
        );
    }
}