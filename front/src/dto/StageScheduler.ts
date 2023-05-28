import {StageSchedulerCode} from "./StageSchedulerCode";

export interface StageScheduler {
    id: number;
    code: StageSchedulerCode;
    description: string;
    startDate: string;
    endDate: string;
    active: boolean;
}