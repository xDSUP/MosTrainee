import {UserType} from "./UserType";

export interface LoginResponse {
    username: string,
    token: string,
    userType: UserType
}