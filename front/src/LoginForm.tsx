import {Component} from "react";
import moscowImage from "./images/moscow.png"
import gosuslugi from "./images/gosuslugi.png"
import {observer} from "mobx-react";
import {action, computed, makeAutoObservable, observable} from "mobx";
import {BasicForm} from "./BasicForm";
import {Button} from "./Button";
import {Input} from "./Input";

class EmailLoginFormState {

    @observable
    email: string;
    @observable
    password: string;

    constructor() {
        this.email = "";
        this.password = ""
        makeAutoObservable(this);
    }

    @computed
    get isFormValid() {
        return !!(this.email) && !!(this.password);
    }

    @action
    setEmail(email: string) {
        this.email = email;
    }

    @action
    setPassword(password: string) {
        this.password = password;
    }

}


@observer
class EmailLoginForm extends Component<{}, EmailLoginFormState> {

    state = new EmailLoginFormState();

    handleEmailChange(event: any) {
        this.state.setEmail(event.target.value);
    }

    handlePasswordChange(event: any) {
        this.state.setPassword(event.target.value);
    }

    render() {
        return (
            <>
                <BasicForm>
                    <Input type="text" value={this.state.email} placeholder="Email" onChange={this.handleEmailChange.bind(this)}/>
                    <Input type="password" value={this.state.password} placeholder="Пароль" onChange={this.handlePasswordChange.bind(this)}/>
                    <Button disabled={!this.state.isFormValid} text="Войти" type="submit"/>
                </BasicForm>

                <div className="flex justify-center">
                    <button className="text-white text-opacity-50">Не помню пароль</button>
                </div>
            </>
        );
    }
}

class PhoneLoginFormState {

    @observable
    phone: string;
    @observable
    code: string;
    @observable
    isCodeInputEnabled: boolean;

    constructor() {
        this.phone = "";
        this.code = "";
        this.isCodeInputEnabled = false;
        makeAutoObservable(this);
    }

    @computed
    get isSendCodeEnabled() {
        return !!(this.phone);
    }

    @action
    setPhone(phone: string) {
        if (phone.length <= 10)
            this.phone = phone;
    }

    @action
    setCode(code: string) {
        this.code = code;
    }

    @action
    sendCode() {
        //post
        this.isCodeInputEnabled = true;
    }

    @computed
    get phoneNumber() {
        return "+7" + this.phone;
    }
}

function split(str: string, index: number) {
    return [str.slice(0, index), str.slice(index)];
}

@observer
class PhoneLoginForm extends Component {

    state = new PhoneLoginFormState();


    handlePhoneChanged(event: any) {
        let fullNumber = event.target.value;
        let number = split(fullNumber, 2);
        if (number.length > 1)
            this.state.setPhone(number[1]);
    }

    handleCodeSent(event: any) {
        this.state.sendCode();
    }

    handleCodeChanged(event: any) {
        this.state.setCode(event.target.value);
    }

    render() {
        return (
            <BasicForm>
                <Input
                    type="tel"
                    value={this.state.phoneNumber}
                    onChange={this.handlePhoneChanged.bind(this)}/>
                <Button
                    text="Отправить код для входа"
                    type="button"
                    disabled={!this.state.isSendCodeEnabled}
                    onClick={this.handleCodeSent.bind(this)}/>
                {
                    this.state.isCodeInputEnabled &&
                    <div >
                        <p className="text-center text-1xl">
                            В SMS отправлен код для входа
                            <br/>
                            Повторно отправить можно через
                        </p>
                    </div>
                }
                {
                    this.state.isCodeInputEnabled &&
                    <Input
                        type="password"
                        value={this.state.code}
                        onChange={this.handleCodeChanged.bind(this)}/>
                }
                {
                    this.state.isCodeInputEnabled &&
                    <Button
                        text="Войти"
                        disabled={!this.state.code}/>
                }
            </BasicForm>
        );
    }
}


class LoginFormState {
    @observable
    isEmailAuth = true;

    constructor() {
        this.isEmailAuth = true;
        makeAutoObservable(this);
    }

    @action
    setIsEmailAuth(isSet: boolean) {
        this.isEmailAuth = isSet;
    }

}

@observer
export class LoginForm extends Component<{className?: string}, LoginFormState> {

    state = new LoginFormState();

    render() {
        return (

            <div className={this.props.className}>
                <div className="flex items-center justify-center my-10 font-header">
                    <img src={moscowImage} alt="moscow" className="mr-3 max-h-11 "/>
                    <h1 className="text-2xl font-bold">ТВОЯ КАРЬЕРА</h1>
                </div>
                <div className="my-10">
                    <p className="text-center text-4xl font-bold font-header">
                        ЗАПУСТИ СВОЮ КАРЬЕРУ
                        <br/>
                        В ПРАВИТЕЛЬСТВЕ МОСКВЫ
                    </p>
                </div>
                <div className="max-w-sm mx-auto">
                    <div className="flex justify-around bg-white bg-opacity-5 text-1xl rounded-md">
                        <button onClick={() => this.state.setIsEmailAuth(true)}
                            className={`my-3 mx-3 text-1xl p-3 rounded-lg transition-all text-white duration-200 ${this.state.isEmailAuth ? "bg-white bg-opacity-10" : "text-opacity-50"}`}>
                            Войти по email
                        </button>
                        <button onClick={() => this.state.setIsEmailAuth(false)}
                            className={`my-3 mx-3 text-1xl p-3 rounded-lg transition-all text-white duration-200 ${!this.state.isEmailAuth ? "bg-white bg-opacity-10" : "text-opacity-50"}`}>
                            Войти по номеру
                        </button>
                    </div>

                    {
                        this.state.isEmailAuth ?
                            <EmailLoginForm/>
                            :
                            <PhoneLoginForm/>
                    }

                    <div className="flex justify-center my-5">
                        <button className="text-white text-opacity-50 ">Зарегистрироваться</button>
                    </div>
                    <button className="flex justify-center items-center bg-white text-black text-xl rounded w-full my-8 h-12">
                        Войти через
                        <img src={gosuslugi} alt="gosuslugi" className="mt-1 ml-2 max-h-4"/>
                    </button>
                </div>
                <div className="fixed bottom-0 left-0 w-1/2">

                    <svg className="w-full h-full" height="136" viewBox="0 0 720 136" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M549.5 95.6654C631 95.6654 687.674 103.674 720 136V418H0.3186L9.54626e-05 0.125246C0.085565 56.1861 57.5517 95.6654 127 95.6654H549.5Z" fill="#FF0F43"/>
                    </svg>
                </div>



            </div>

        );
    }
}