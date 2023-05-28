import {ParticipantStatus} from "./ParticipantStatus";

export interface Participant {
    id: number;
    lastName: string;
    firstName: string;
    middleName: string;
    birthDate: string;
    nationality: string;
    citizenship: string;
    rating: number;
    educationType: string;
    status: ParticipantStatus;
}