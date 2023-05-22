import {Component} from "react";
import {LoginForm} from "./LoginForm";
import rightImage from "./images/right.png"

export type PageType = "LOGIN" | "REGISTRATION"

class LoginRegistrationState {

    type: PageType;

    constructor(type: PageType) {
        this.type = type;
    }
}

export class LoginRegistrationPage extends Component<{type: PageType}, LoginRegistrationState> {
    render() {
        return (
            <div className="laptop:flex bg-main">
                <LoginForm className="laptop:w-1/2 text-white"/>
                <div className="laptop:w-1/2 h-screen hidden laptop:block rounded-tl-[110px] overflow-hidden">

                    <img
                        src={rightImage}
                        className=""
                        alt="right"
                    />
                </div>
            </div>
        );
    }
}