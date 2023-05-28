import {Organization} from "./Organization";
import {Mentor} from "./Mentor";
import {SolutionStatus} from "./SolutionStatus";

export interface Solution {
    id: number;
    status: SolutionStatus;
    vacancy: string;
    organization: Organization;
    mentor: Mentor;
    createdAt: string;
}