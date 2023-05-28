import {Component} from "react";
import AxiosUtils from "../utils/AxiosUtils";
import {Urls} from "../utils/Urls";
import {observer} from "mobx-react";
import {action, computed, makeAutoObservable} from "mobx";
import {Solution} from "../dto/Solution";
import {SolutionStatus} from "../dto/SolutionStatus";
import {ReactComponent as Waiting} from "../icons/waiting.svg"
import {ReactComponent as Checked} from "../icons/checked.svg"
import {ReactComponent as Pause} from "../icons/pause.svg"
import {ReactComponent as Close} from "../icons/close.svg"
import {ReactComponent as Dots} from "../icons/dots-menu.svg"
import Popup from "reactjs-popup";

class InternshipTableState {
    solutions: Solution[] = [];

    constructor() {
        makeAutoObservable(this);
    }

    @action
    setApplications(solutions: Solution[]) {
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

class InternshipStatusLabel extends Component<{status: SolutionStatus}> {

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
export class InternshipTablePreHeader extends Component<{state: InternshipTableState}, InternshipTableState> {
    state = this.props.state;
    render() {
        return (
            <div className="flex flex-row justify-between mb-3">

                <div className="flex flex-col">
                    <span className="text-black text-3xl font-bold">Стажёры</span>
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

class InternshipPopup extends Component {

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
export class InternshipTable extends Component<{}, InternshipTableState> {

    state = new InternshipTableState();
    componentDidMount() {
        AxiosUtils.get<Solution[]>(Urls.serverUrl + "/api/participant/solution/")
            .then(r => {
                this.state.setApplications(r as Solution[])
            })
    }

    render() {
        return (
            <div className="shadow-xl w-full bg-white rounded-[10px] p-3 text-left">
                <InternshipTablePreHeader state={this.state}/>
                <table className="min-w-full divide-y divide-gray-200">
                    <thead className="border-b border-t border-gray-300">
                    <tr>
                        <th scope="col" className="px-6 py-3">Статус</th>
                        <th scope="col" className="px-6 py-3">Должность</th>
                        <th scope="col" className="px-6 py-3">Организация</th>
                        <th scope="col" className="px-6 py-3">Наставник</th>
                        <th scope="col" className=""></th>
                    </tr>
                    </thead>
                    <tbody className="divide-y text-left">
                    {
                        this.state.solutions.map(solution => {

                            return (
                                <tr>
                                    <td className="px-6 py-3"><InternshipStatusLabel status={solution.status}/></td>
                                    <td className="px-6 py-3">{solution.vacancy}</td>
                                    <td className="px-6 py-3">{solution.organization.name}</td>
                                    <td className="px-6 py-3">{solution.mentor.firstName} {solution.mentor.lastName}</td>
                                    <td className="">
                                        <InternshipPopup/>
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