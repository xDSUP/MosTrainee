import {Component} from "react";
import moscowImage from "../images/moscow.png";
import "./css/logo.css"

export class Logo extends Component {
    render() {
        return (
            <div className="logo my-10">
                <img src={moscowImage} alt="moscow" className="mr-3 max-h-11 "/>
                <h1 className="text-white text-2xl font-bold">ТВОЯ КАРЬЕРА</h1>
            </div>
        );
    }
}