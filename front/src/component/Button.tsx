import React, {Component} from "react";
import "./css/button.css"

interface ButtonProps {
    disabled?: boolean,
    className?: string,
    hidden?: boolean,
    type?: 'submit' | 'reset' | 'button' | undefined,
    text?: string,
    onClick?: (event: React.MouseEvent) => void;
    children?: React.ReactNode
}

export class Button extends Component<ButtonProps> {
    render() {
        return (
            <button className={`${this.props.className} button bg-red-500 flex flex-row
                        ${this.props.hidden ? "hidden" : ""}
                        ${this.props.disabled ? "bg-element bg-opacity-50" : "bg-element"}`}
                    onClick={this.props.onClick}
                    type={this.props.type}
                    disabled={this.props.disabled}>
                {this.props.children}
                {this.props.text}
            </button>
        );
    }
}