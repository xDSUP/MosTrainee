import React, {Children, Component, ReactNode} from "react";
import "./css/basicform.css"

export class BasicForm extends Component<{children: ReactNode, className?: string}> {
    render() {
        const { children} = this.props;
        const filteredChildren = Children.toArray(children).filter(Boolean) as React.ReactElement[];
        return (
            <form className={`${this.props.className} basic-form`}>
                {filteredChildren.map((child, index) => {
                    const isLastChild = index === filteredChildren.length - 1;
                    if (React.isValidElement(child)) {
                        return React.cloneElement(child as React.ReactElement<any>, {
                            className: `mx-5 ${isLastChild ? "mt-5 mb-5" : "mt-5"}`,
                        });
                    }
                    return child;
                })}
            </form>
        );
    }
}