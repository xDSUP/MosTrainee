import React, {Component, ReactNode} from "react";

interface ContentPageProps {
    children: ReactNode;
}

export class ContentPage extends Component<ContentPageProps> {
    render() {
        return (
            <div className="flex mt-7 ml-72 ">
                {this.props.children}
            </div>
        );
    }
}