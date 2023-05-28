import {Activity} from "./Activity";

export interface Stage {
    id: number;
    code: string;
    description: string;
    linkToExtResource: string;
    startDate: string,
    endDate: string,
    active: boolean,
    activities: Activity[];
}