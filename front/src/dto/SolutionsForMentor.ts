import {SimpleParticipant} from "./SimpleParticipant";
import {SolutionStatus} from "./SolutionStatus";

export interface SolutionsForMentor {
    id: number;
    status: SolutionStatus;
    participant: SimpleParticipant;
    score: string;
}