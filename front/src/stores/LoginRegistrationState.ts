import {action, makeAutoObservable, observable} from "mobx";

export type PageType = "LOGIN" | "REGISTRATION"

class LoginRegistrationState {

    @observable
    type: PageType;

    constructor() {
        this.type = "LOGIN";
        makeAutoObservable(this);
    }

    @action
    setPageType(type: PageType) {
        this.type = type;
    }
}

const loginRegistrationState = new LoginRegistrationState();
export default loginRegistrationState;