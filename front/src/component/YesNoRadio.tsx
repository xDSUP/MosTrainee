import React, {Component} from "react";

interface YesNoRadioProps {
    question?: string,
    description?: string,
    className?: string,
}


export class YesNoRadio extends Component<YesNoRadioProps> {
    render() {
        return (
            <div className={`${this.props.className}`}>
                <h2>{this.props.question}</h2>
                <p className="text-white opacity-20 mt-1">{this.props.description}</p>
                <div className="flex flex-row justify-items-start mt-2">
                    <div className="mr-4">

                        <input checked id="default-radio-1" type="radio" value="" name="default-radio" />
                        <label htmlFor="default-radio-1"> Да</label>
                    </div>
                    <div className="ml-4">
                        <input id="default-radio-2" type="radio" value="" name="default-radio" />
                        <label htmlFor="default-radio-2"> Нет</label>
                    </div>
                </div>
            </div>
        );
    }
}