import {Component} from "react";
import {LoginForm} from "./LoginForm";
import rightImage from "../images/right.webp"
import {observer} from "mobx-react";
import {RegistrationForm} from "./RegistrationForm";

import loginRegistrationState from "../stores/LoginRegistrationState";

@observer
export class LoginRegistrationPage extends Component<{}> {
    state = loginRegistrationState;
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