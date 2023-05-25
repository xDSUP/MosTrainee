import {Component} from "react";
import {MainContent} from "./MainContent";
import "./css/fixed-right-block.css"
export class CenterPage extends Component {
    render() {
        return (
            <div className="flex mt-7 ml-72 ">
                <MainContent/>
                <div className="fixed-right-block">
                    <h2>Закрепленный блок с информацией</h2>
                    <p>Дополнительная информация о контенте.</p>
                </div>
            </div>
        );
    }
}