import * as React from 'react';
import CalendarMock from "../images/calendar.png";

export class Calendar extends React.Component<{}> {
    render() {
        return (
            <div>
                <div className="relative p-6 flex-auto">
                    <img src={CalendarMock} alt="CalendarMock"/>
                </div>
            </div>
        );
    };
};