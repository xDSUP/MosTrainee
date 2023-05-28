import {Mentor} from "./Mentor";
import {Organization} from "./Organization";
import {InternshipType} from "./InternshipType";
import {Branch} from "./Branch";
import {Attachment} from "./Attachment";

export interface Application {
    id: number;
    name: string;
    description: string;
    requirement: string;
    workTime: string;
    type: string;
    mentor: Mentor;
    organization: Organization;
    internshipType: InternshipType;
    branch: Branch;
    createdAt: string;
    isActive: boolean;
    attachments: Attachment[];
}