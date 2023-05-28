import {Component} from "react";
import AxiosUtils from "../utils/AxiosUtils";
import {Urls} from "../utils/Urls";
import {observer} from "mobx-react";
import {action, computed, makeAutoObservable} from "mobx";
import {ReactComponent as Waiting} from "../icons/waiting.svg"
import {ReactComponent as Close} from "../icons/close.svg"
import {ReactComponent as Location} from "../icons/location.svg"
import {ReactComponent as Award} from "../icons/award.svg"
import {ParticipantStatus} from "../dto/ParticipantStatus";
import {Participant} from "../dto/Participant";

class CandidatesTableState {
    participants: Participant[] = [];

    constructor() {
        makeAutoObservable(this);
    }

    @action
    setSolutions(participant: Participant[]) {
        this.participants = participant;
    }


    @computed
    get participantsSize() {
        return this.participants.length;
    }

}

class CandidatesStatusLabel extends Component<{status: ParticipantStatus}> {

    render() {
        let className = "rounded-[10px] p-1 w-min border ";
        let icon = null;

        switch (this.props.status) {
            case ParticipantStatus.PENDING:
                className += "bg-green-400"
                icon = <Waiting className="stroke-black"/>
                break;
            case ParticipantStatus.NOT_RELEVANT:
                className += "bg-red-400"
                icon = <Close className="stroke-black"/>
                break;
            case ParticipantStatus.RELEVANT:
                className += "bg-green-400"
                icon = <Waiting className="stroke-black"/>
                break;
            case ParticipantStatus.REJECTED:
                className += "bg-gray-100"
                icon = <Close className="stroke-black"/>
                break;
            case ParticipantStatus.CANDIDATE:
                className += "bg-gray-100"
                icon = <Award className="stroke-black"/>
                break;
            case ParticipantStatus.INTERN:
                className += "bg-yellow-400"
                icon = <Location className="stroke-black"/>
                break;
            default:
                className += "bg-yellow-400"
                icon = <Location className="stroke-black"/>
                break;
        }

        return <div className={className}>
            {icon}
        </div>;
    }
}


@observer
export class CandidatesTablePreHeader extends Component<{state: CandidatesTableState}, CandidatesTableState> {
    state = this.props.state;
    render() {
        return (
            <div className="flex flex-row justify-between mb-3">

                <div className="flex flex-col">
                    <span className="text-black text-3xl font-bold">Кандидаты на стажировку</span>
                </div>

                <input className="rounded border border-gray-300 px-3 py-1 mb-4" type="text" placeholder="Поиск"/>
            </div>
        );
    }
}

@observer
export class CandidatesTable extends Component<{}, CandidatesTableState> {

    state = new CandidatesTableState();
    componentDidMount() {
        AxiosUtils.get<Participant[]>(Urls.serverUrl + "/api/participant/all")
            .then(r => {
                this.state.setSolutions(r as Participant[])
            })
    }

    render() {
        return (
            <div className="shadow-xl w-full bg-white rounded-[10px] p-3 text-left">
                <CandidatesTablePreHeader state={this.state}/>
                <table className="min-w-full divide-y divide-gray-200">
                    <thead className="border-b border-t border-gray-300">
                    <tr>
                        <th scope="col" className="px-6 py-3">Фио</th>
                        <th scope="col" className="px-6 py-3">Опыт</th>
                        <th scope="col" className="px-6 py-3">Образование</th>
                        <th scope="col" className="px-6 py-3">Баллы</th>
                        <th scope="col" className="px-6 py-3">Статус</th>
                    </tr>
                    </thead>
                    <tbody className="divide-y text-left">
                    {
                        this.state.participants.map(participant => {

                            return (
                                <tr>
                                    <td className="px-6 py-3">{participant.firstName} {participant.middleName} {participant.lastName}</td>
                                    <td className="px-6 py-3">Да</td>
                                    <td className="px-6 py-3">{participant.educationType}</td>
                                    <td className="px-6 py-3">{participant.rating}</td>
                                    <td className="px-6 py-3">
                                        <CandidatesStatusLabel status={participant.status}/>
                                    </td>
                                </tr>
                            )
                        })
                    }
                    </tbody>
                </table>
            </div>

        );
    }
}