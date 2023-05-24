import {Component} from "react";
import {LoginForm} from "./LoginForm";
import rightImage from "../images/right.webp"
import {observer} from "mobx-react";
import {action, observable} from "mobx";
import {RegistrationForm} from "./RegistrationForm";

export type PageType = "LOGIN" | "REGISTRATION"

class LoginRegistrationState {

    @observable
    type: PageType;

    constructor() {
        this.type = "LOGIN";
    }

    @action
    setPageType(type: PageType) {
        this.type = type;
    }
}

@observer
export class LoginRegistrationPage extends Component<{},LoginRegistrationState> {
    state = new LoginRegistrationState();
    render() {
        return (
            <div className="laptop:flex bg-main">
                {
                    this.state.type === "LOGIN" ?
                        <LoginForm className="laptop:w-1/2 text-white relative"/> :
                        <RegistrationForm className="laptop:w-1/2 text-white relative"/>
                }
                <div className="laptop:w-1/2 h-screen hidden laptop:block rounded-tl-[110px] overflow-hidden">

                    <img
                        src={rightImage}
                        className="asdf"
                        alt="right"
                    />
                </div>
            </div>
        );
    }
}