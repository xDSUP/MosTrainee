import React, {Component} from "react";

interface InputProps {
    type: string,
    value: string,
    className?: string,
    hidden?: boolean,
    disabled?: boolean,
    placeholder?: string,
    onChange?: React.ChangeEventHandler | undefined
}

export class Input extends Component<InputProps> {
    render() {
        return (
            <input
                className={`${this.props.className} text-black px-3 py-2 border border-gray-300 rounded focus:outline-none
                    ${this.props.hidden ? "hidden" : ""}`}
                type={this.props.type}
                disabled={this.props.disabled}
                value={this.props.value}
                placeholder={this.props.placeholder}
                onChange={this.props.onChange}
            />
        );
    }
}