import {Component} from "react";
import AxiosUtils from "../utils/AxiosUtils";
import {Urls} from "../utils/Urls";
import {observer} from "mobx-react";
import {action, computed, makeAutoObservable} from "mobx";
import {SolutionStatus} from "../dto/SolutionStatus";
import {ReactComponent as Waiting} from "../icons/waiting.svg"
import {ReactComponent as Checked} from "../icons/checked.svg"
import {ReactComponent as Pause} from "../icons/pause.svg"
import {ReactComponent as Close} from "../icons/close.svg"
import {ReactComponent as Dots} from "../icons/dots-menu.svg"
import Popup from "reactjs-popup";
import {SolutionsForMentor} from "../dto/SolutionsForMentor";

class InternshipForMentorTableState {
    solutions: SolutionsForMentor[] = [];

    constructor() {
        makeAutoObservable(this);
    }

    @action
    setSolutions(solutions: SolutionsForMentor[]) {
        this.solutions = solutions;
    }

    @computed
    get solutionsSize() {
        return this.solutions.length;
    }

    @computed
    get solutionsInvitedSize() {
        return this.solutions.filter(sol => sol.status === SolutionStatus.INVITED).length;
    }

}

class InternshipForMentorStatusLabel extends Component<{status: SolutionStatus}> {

    render() {
        let className = "flex flex-row justify-start rounded text-black text-center ";
        let text = "";
        let icon = null;

        switch (this.props.status) {
            case SolutionStatus.APPROVED:
                className += "bg-gray-600";
                text = "Прошёл"
                icon = <Checked className="mx-3 stroke-black"/>
                break;
            case SolutionStatus.FAILURE:
                className += "bg-red-400";
                text = "Проверка не пройдена"
                icon = <Close className="mx-3 stroke-black"/>
                break;
            case SolutionStatus.INVITED:
                className += "bg-green-400";
                text = "Приглашение"
                icon = <Checked className="mx-3 stroke-black"/>
                break;
            case SolutionStatus.PENDING:
                className += "bg-violet-400";
                icon = <Waiting className="mx-3 stroke-black"/>
                text = "Ожидание"
                break;
            case SolutionStatus.REJECTED:
                className += "bg-red-400";
                text = "Отклнонено"
                icon = <Close className="mx-3 stroke-black"/>
                break;
            case SolutionStatus.RESERVED:
                className += "bg-gray-400";
                text = "В резерве"
                icon = <Pause className="mx-3 stroke-black"/>
                break;
        }

        return <div className={className}>
            {icon}
            {text}
        </div>;
    }
}


@observer
export class InternshipForMentorTablePreHeader extends Component<{state: InternshipForMentorTableState}, InternshipForMentorTableState> {
    state = this.props.state;
    render() {
        return (
            <div className="flex flex-row justify-between mb-3">

                <div className="flex flex-col">
                    <span className="text-black text-3xl font-bold">Кандидаты на стажировку </span>
                    <span>Выбери до 24 июня</span>
                </div>

                <div className="flex flex-row text-center">
                    <div className="flex flex-col mr-4">
                        <span className="text-black text-3xl font-bold">{this.state.solutionsInvitedSize}</span>
                        <span>Приглашения</span>
                    </div>
                    <div className="border-r">

                    </div>
                    <div className="flex flex-col ml-4">
                        <span className="text-black text-3xl font-bold">{this.state.solutionsSize}</span>
                        <span>Отклики</span>
                    </div>
                </div>
            </div>
        );
    }
}

class InternshipForMentorPopup extends Component {

    render() {
        return (
            <Popup trigger={<Dots className="stroke-gray-600 stroke-2 hover:stroke-black"/>} position="bottom right" nested>

                <div className="flex flex-col bg-gray-100 rounded-[10px] shadow-2xl">

                    <button className="block text-left my-2 p-2">Загрузить тестовое</button>
                    <div className="border-t border-gray-300"/>
                    <button className="block text-left my-2 p-2">Подробнее о вакансии</button>
                    <div className="border-t border-gray-300"/>
                    <button className="block text-left my-2 p-2">Отказаться</button>
                </div>
            </Popup>
        );
    }
}
@observer
export class InternshipForMentorTable extends Component<{}, InternshipForMentorTableState> {

    state = new InternshipForMentorTableState();
    componentDidMount() {
        AxiosUtils.get<SolutionsForMentor[]>(Urls.serverUrl + "/api/application/solutions/")
            .then(r => {
                this.state.setSolutions(r as SolutionsForMentor[])
            })
    }

    render() {
        return (
            <div className="shadow-xl w-full bg-white rounded-[10px] p-3 text-left mt-6">
                <InternshipForMentorTablePreHeader state={this.state}/>
                <table className="min-w-full divide-y divide-gray-200">
                    <thead className="border-b border-t border-gray-300">
                    <tr>
                        <th scope="col" className="px-6 py-3">Статус</th>
                        <th scope="col" className="px-6 py-3">Фио</th>
                        <th scope="col" className="px-6 py-3">Общий балл</th>
                        <th scope="col" className="px-6 py-3">Тестовое</th>
                        <th scope="col" className=""></th>
                    </tr>
                    </thead>
                    <tbody className="divide-y text-left">
                    {
                        this.state.solutions.map(solution => {

                            return (
                                <tr>
                                    <td className="px-6 py-3"><InternshipForMentorStatusLabel status={solution.status}/></td>
                                    <td className="px-6 py-3">{solution.participant.firstName} {solution.participant.middleName} {solution.participant.lastName}</td>
                                    <td className="px-6 py-3">{solution.participant.rating}</td>
                                    <td className="px-6 py-3">{solution.score}</td>
                                    <td className="">
                                        <InternshipForMentorPopup/>
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