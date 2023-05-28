import {ParticipantStatus} from "./ParticipantStatus";

export interface SimpleParticipant {
    id: number;
    lastName: string;
    firstName: string;
    middleName: string;
    educationType: string;
    rating: string;
    status: ParticipantStatus;
}