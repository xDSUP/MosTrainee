import {ParticActivityHist} from "./ParticActivityHist";

export interface Activity {
    id: number,
    stageId: number,
    code: string,
    description: string,
    linkToExtResource: string,
    startDateTime: string,
    endDateTime: string,
    activityType: string,
    particActivity: ParticActivityHist | undefined,
}