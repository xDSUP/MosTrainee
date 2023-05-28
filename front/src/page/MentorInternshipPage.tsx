import React, {Component} from "react";
import {MainContent} from "./MainContent";
import {InternshipForMentorTable} from "../component/InternshipForMentorTable";
import {RightBlock} from "./RightBlock";
import {ContentPage} from "./ContentPage";
import {action, makeAutoObservable} from "mobx";
import {observer} from "mobx-react";
import {Application} from "../dto/Application";
import AxiosUtils from "../utils/AxiosUtils";
import {Urls} from "../utils/Urls";
import {Button} from "../component/Button";
import modal from "../images/modal_form2.png"
import {Clearfix} from "../component/Clearfix";
import {ReactComponent as Edit} from "../icons/settings.svg";
import {ReactComponent as Waiting} from "../icons/waiting.svg"
import {ReactComponent as Checked} from "../icons/checked.svg"

class MentorInternshipPageState {

    application: Application | unknown = null;
    applicationFormVisible = false;

    constructor() {
        AxiosUtils.get<Application>(Urls.serverUrl + "/api/application/for-current-mentor")
            .then(r => {
                console.log(r);
                this.application = r as Application;
            })

        makeAutoObservable(this);
    }

    @action.bound
    openApplicationForm() {
        console.log(1)
        this.applicationFormVisible = true;
    }

    @action.bound
    closeApplicationForm() {
        this.applicationFormVisible = false;
    }
}


function Modal() {
    const [showModal, setShowModal] = React.useState(false);
    return (
        <>
            <Button className="bg-white shadow border text-violet-600" text="Подать заявку" onClick={() => setShowModal(true)}/>
            {showModal ? (
                <>
                    <div
                        className="justify-center items-center flex overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none"
                    >
                        <div className="relative w-auto my-6 mx-auto max-w-3xl">
                            {/*content*/}
                            <div className="border-0 rounded-lg shadow-lg relative flex flex-col w-full bg-white outline-none focus:outline-none">
                                {/*body*/}
                                <div className="relative p-6 flex-auto">
                                    <img
                                        src={modal} alt="Form"
                                    />
                                    <Button className="bg-white shadow border text-violet-600 w-full" text="Отправить заявку" onClick={() => setShowModal(false)}/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="opacity-25 fixed inset-0 z-40 bg-black"></div>
                </>
            ) : null}
        </>
    );
}

@observer
class NoApplications extends Component<{state: MentorInternshipPageState}, MentorInternshipPageState> {

    state = this.props.state;

    render() {
        return (
            <>
                <div className="my-5 w-1/3">
                    <span className="text text-black text-3xl font-bold">Нет заявок</span>
                    <p>Вы можете отправить заявку на стажёра, заполнив карточку вакансии и прикрепив тестовое задание.</p>
                    <Modal/>
                </div>

            </>
        );
    }
}


@observer
class ApplicationActive extends Component<{state: MentorInternshipPageState}, MentorInternshipPageState> {

    state = this.props.state;

    render() {
        let className = "flex flex-row rounded ";

        const app = this.state.application as Application;
        let icon = null;
        let text = "";

        if (app.isActive) {
            className += "bg-green-400 w-1/2 my-2";
            icon = <Checked className="stroke-black mr-3"/>;
            text += "Опубликовано";
        }
        else {

            className += "bg-violet-600 w-1/2 my-2";
            icon = <Waiting className="stroke-black mr-3"/>;
            text += "Ожидает проверки"
        }
        return (
            <div className={className}>
                {icon}
                {text}
            </div>
        );
    }
}

@observer
class ApplicationCard extends Component<{state: MentorInternshipPageState}, MentorInternshipPageState> {

    state = this.props.state;

    render() {
        const app = this.state.application as Application;
        if (app === null)
            return;
        return (
            <div className="flex flex-col mb-5">

                <div className="flex flex-row justify-between mx-3 mt-3 mb-1 text-center items-center">
                    <span className="text-black text-3xl font-bold">Стажировка</span>
                    <Button  className="bg-white" text="Изменить">
                        <Edit className="stroke-black mr-2"/>
                    </Button>
                </div>

                <div className="flex flex-row m-3  p-3 text-left items-center bg-white shadow-xl rounded-[10px] border border-gray-300 text-gray-600">
                    <div className="flex flex-col w-1/2 border-r border-gray-300 text-black">
                        <ApplicationActive state={this.state}/>
                        <h1 className="text-xl">{app.name}</h1>
                        <span>{app.workTime}</span>
                        <span>{app.requirement}</span>
                        <span>{app.internshipType.description}</span>
                    </div>
                    <div className="w-1/2 px-3">

                        <span className="">Можно откликнуться до 24 июля, 12:00</span>
                        <h1 className="text-xl text-black">{app.organization.name}</h1>
                        <p>{app.organization.info}</p>
                    </div>
                </div>
            </div>
        );
    }
}

@observer
export class MentorInternshipPage extends Component<{}, MentorInternshipPageState> {

    state = new MentorInternshipPageState();

    render() {
        let app = this.state.application as Application;
        return (
            <ContentPage>
                <MainContent>
                    {
                        app === null &&
                        <NoApplications state={this.state}/>
                    }

                    {
                        app !== null &&
                        <>
                            <ApplicationCard state={this.state}/>
                            {
                                app.isActive &&
                                <>
                                    <Clearfix/>
                                    <InternshipForMentorTable/>
                                </>
                            }
                        </>
                    }
                </MainContent>
                <RightBlock>
                </RightBlock>
            </ContentPage>
        );
    }
}