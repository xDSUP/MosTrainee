import React, {Component} from "react";

export class MenuSpan extends Component<{
    isActive?: boolean,
    text?: string
    icon: React.ComponentType<React.SVGProps<SVGSVGElement>>
}> {
    render() {
        const { isActive, text, icon: Icon } = this.props;
        const active = isActive ? "bg-white bg-opacity-10" : "text-opacity-30";
        const className = `block transition-all text-center p-2 rounded-[15px] text-white ${active}`;
        const iconClassName = isActive ? "transition-all stroke-white" : "transition-all stroke-gray-600"; // Добавление класса стиля для иконки

        return (
            <div className={`flex flex-row ${className}`}>
                <div className="my-auto mr-2">
                    <Icon className={iconClassName} /> {/* Применение класса стиля для иконки */}
                </div>
                <span>{text}</span>
            </div>
        );
    }
}