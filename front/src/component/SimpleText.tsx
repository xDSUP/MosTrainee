import {Component} from "react";


interface SimpleTextProps {
    text?: string,
    className?: string,
}

export class SimpleText extends Component<SimpleTextProps> {
    render() {
        return (
            <div className={this.props.className}>
                <p>
                    При нажатии на кнопку «Поехали!» вы принимаете соглашение об обработке персональных данных
                    и даете согласие на использование ваших персональных данных. Вы подтверждаете, что ознакомились с
                    политикой конфиденциальности и согласны с ее условиями.
                </p>
            </div>
        );
    }
}