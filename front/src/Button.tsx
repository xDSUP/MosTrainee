import React, {Component} from "react";

interface ButtonProps {
    disabled?: boolean,
    className?: string,
    hidden?: boolean,
    type?: 'submit' | 'reset' | 'button' | undefined,
    text?: string,
    onClick?: (event: React.MouseEvent) => void;
}

export class Button extends Component<ButtonProps> {
    render() {
        return (
            <button className={`${this.props.className}  flex justify-center px-3 py-2 rounded-md transition-all duration-400 
                        ${this.props.hidden ? "hidden" : ""}
                        ${this.props.disabled ? "bg-element bg-opacity-50" : "bg-element"}`}
                    onClick={this.props.onClick}
                    type={this.props.type}
                    disabled={this.props.disabled}>
                {this.props.text}
            </button>
        );
    }
}