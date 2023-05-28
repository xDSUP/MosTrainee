import React, {Component} from "react";
import {observer} from "mobx-react";
import {LeftMainMenu} from "./LeftMainMenu";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {MainContent} from "./MainContent";
import {InternshipTable} from "../component/InternshipTable";
import {RightBlock} from "./RightBlock";
import {CurrentDateHeader} from "../component/CurrentDateHeader";
import {WebinarCardList} from "../component/WebinarCardList";
import {CandidatesTable} from "../component/CandidatesTable";
import {ContentPage} from "./ContentPage";
import {InternshipForMentorTable} from "../component/InternshipForMentorTable";
import {CandidateProgress} from "../component/CandidateProgress";

@observer
export class MainPage extends Component {
    render() {
        return (
            <BrowserRouter>
                <LeftMainMenu/>
                <Routes>
                    <Route
                        path="/partic/center"
                        element={
                        <ContentPage>
                            <MainContent>
                                <CandidateProgress/>
                                <InternshipTable/>
                            </MainContent>
                            <RightBlock>
                                <CurrentDateHeader/>
                                <WebinarCardList/>
                            </RightBlock>
                        </ContentPage>
                    }
                    />

                    <Route
                        path="/supervisor/trainee"
                        element={
                        <ContentPage>
                            <MainContent>
                                <CandidatesTable/>
                            </MainContent>
                            <RightBlock>
                            </RightBlock>
                        </ContentPage>
                    }
                    />

                    <Route
                        path="/mentor/internship"
                        element={
                            <ContentPage>
                                <MainContent>
                                    <InternshipForMentorTable/>
                                </MainContent>
                                <RightBlock>
                                </RightBlock>
                            </ContentPage>
                        }
                    />
                </Routes>
            </BrowserRouter>
        );
    }
}