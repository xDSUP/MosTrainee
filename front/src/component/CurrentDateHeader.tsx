import {Component} from "react";
import { format } from 'date-fns';
import {ru} from 'date-fns/locale';

class CurrentDateHeaderState {

    day: string;
    month: string;

    constructor() {
        let currentDate = new Date();

        const formattedDate = format(currentDate, 'd MMMM', { locale: ru });
        const dayMonth = formattedDate.split(' ');
        this.day = dayMonth[0];
        this.month = dayMonth[1];
    }
}

export class CurrentDateHeader extends Component<{}, CurrentDateHeaderState> {
    state = new CurrentDateHeaderState();

    render() {
        return (
            <div className="relative flex flex-col border-b border-gray-300 pb-5">
                <div className="text-center text-red-600 text-8xl">
                    <span>{this.state.day}</span>
                </div>
                <div className="text-center text-black text-7xl">
                    <span>{this.state.month}</span>
                </div>
            </div>
        );
    }
}