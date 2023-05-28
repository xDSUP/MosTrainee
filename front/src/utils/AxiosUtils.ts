import axios from "axios";
import authStore from "../stores/AuthStore";
import {LoginResponse} from "../dto/LoginResponse";
import LocalStorageKeyNames from "./LocalStorageKeyNames";

export default class AxiosUtils {
    static get<T>(url: string): Promise<T | void> {

        return axios
            .create({headers: {Authorization: `${localStorage.getItem(LocalStorageKeyNames.token)}`}})
            .get<T>(url).then(r => r.data)
            .catch(error => {
                alert(error.message);
                window.location.href = '/';
                if (error.response.status === 403) {
                    authStore.signOut();
                }
            });
    }

    static post<T>(url: string, data: T): Promise<T | void> {

        return axios
            .create({headers: {Authorization: `${localStorage.getItem(LocalStorageKeyNames.token)}`}})
            .post<T>(url).then(r => r.data)
            .catch(error => {
                alert(error.message);
                window.location.href = '/';
                if (error.response.status === 403) {
                    authStore.signOut();
                }
            });
    }

    static login<LoginRequest>(url: string, data: LoginRequest): Promise<LoginResponse | void> {
        return axios.post(url, data)
            .then(r => r.data as LoginResponse)
    }
}