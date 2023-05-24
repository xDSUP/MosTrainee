import React, {Component} from "react";
import "./css/input.css"
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
                className={`${this.props.className} input
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