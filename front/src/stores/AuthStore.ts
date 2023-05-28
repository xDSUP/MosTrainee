import {action, computed, makeAutoObservable, observable} from "mobx";
import AxiosUtils from "../utils/AxiosUtils";
import {getContextPath} from "../utils/SystemUtils";
import {LoginRequest} from "../dto/LoginRequest";
import {LoginResponse} from "../dto/LoginResponse";
import LocalStorageKeyNames from "../utils/LocalStorageKeyNames";

class AuthStore {

    @observable
    isAuthorized: boolean;

    constructor() {
        this.isAuthorized = false;
        makeAutoObservable(this);
    }

    @action
    init() {
        !!localStorage.getItem(LocalStorageKeyNames.token) ?
            this.isAuthorized = true :
            this.isAuthorized = false;
    }

    @action
    signIn(username: string, password: string) {
        AxiosUtils.login<LoginRequest>(getContextPath() + "/api/login", {username: username, password: password})
            .catch(error => alert(error.message))
            .then(r  => {
                this.isAuthorized = true;
                localStorage.setItem(LocalStorageKeyNames.token, (r as LoginResponse).token);
                localStorage.setItem(LocalStorageKeyNames.userType, (r as LoginResponse).userType);
            });
    }

    @action
    signOut() {
        this.isAuthorized = false;
        localStorage.removeItem(LocalStorageKeyNames.token);
    }

    @computed
    get userType() {
        return localStorage.getItem(LocalStorageKeyNames.userType);
    }
}

const authStore = new AuthStore();

export default authStore;