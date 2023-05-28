import {Component, ReactNode} from "react";
import "./css/maincontent.css"

interface MainContentProps {
    children: ReactNode;
}

export class MainContent extends Component<MainContentProps> {
    render() {
        return (
            <div className="main-content">
                {this.props.children}
            </div>
        );
    }
}