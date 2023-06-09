import React, {Component, ReactNode} from "react";
import "./css/fixed-right-block.css"

interface RightCenterBlockProps {
    children: ReactNode;
}

export class RightBlock extends Component<RightCenterBlockProps> {
    render() {
        return (
            <div className="fixed-right-block">
                {this.props.children}
            </div>
        );
    }
}