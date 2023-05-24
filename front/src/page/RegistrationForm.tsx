import React, {Component} from "react";
import {Logo} from "../component/Logo";
import {action, computed, makeAutoObservable, observable} from "mobx";
import {Countdown} from "../component/Countdown";
import {BasicForm} from "../component/BasicForm";
import {Input} from "../component/Input";
import {Button} from "../component/Button";
import {observer} from "mobx-react";
import {YesNoRadio} from "../component/YesNoRadio";


class RegistrationFormState {

    @observable
    stage = 1;

    @observable
    surname = "";
    @observable
    name = "";
    @observable
    lastname = "";
    @observable
    RFСitizenship = true;


    @observable
    email = "";
    @observable
    phoneNumber = "";
    @observable
    dateOfBirth = "";

    @observable
    student = "";
    @observable
    university = "";
    @observable
    internshipDirection = "";

    constructor() {

        makeAutoObservable(this);
    }
    @action
    incrementStage() {
        console.log('!')
        this.stage++;
        console.log(this.stage);
    }

    @computed
    get currentStage() {
        return this.stage;
    }

}

@observer
export class RegistrationForm extends Component<{className?: string}> {
    state = new RegistrationFormState();

    handleIncrementStage(event: any) {
        this.state.incrementStage();
    }

    handleInputChange(event: any) {
        console.log(event.target.name);
        console.log(event.target.value);
    }

    render() {
        const { stage } = this.state;

        return (
            <div className={this.props.className}>
                <Logo/>

                <div className="mt-10">
                    <h1 className="text-4xl text-center font-bold">
                        РЕГИСТРАЦИЯ
                    </h1>
                </div>

                <div className="max-w-sm mx-auto my-7">
                    <p className="text-center text-white text-base leading-tight text-opacity-30 font-header">
                        Для тебя это маленький шаг, но гигантский скачок для начала твоей карьеры
                        в Правительстве Москвы.
                        <br/>
                        Стартуем на счёт 3..2..1..
                    </p>
                </div>

                <Countdown  stagesSize={3} activeStage={this.state.currentStage}/>

                <BasicForm className="max-w-sm mx-auto">
                    {stage === 1 && <Input type="text" placeholder="Фамилия" value={this.state.surname} onChange={this.handleInputChange.bind(this)}/>}
                    {stage === 1 && <Input type="text" placeholder="Имя" value={this.state.name} onChange={this.handleInputChange.bind(this)}/>}
                    {stage === 1 && <Input type="text" placeholder="Отчество" value={this.state.lastname} onChange={this.handleInputChange.bind(this)}/>}
                    {stage === 1 && <Button type="button" onClick={this.handleIncrementStage.bind(this)} text="Далее" />}
                    {stage === 1 && <YesNoRadio question="Гражданство РФ"/>}

                    {stage === 2 && <Input type="text" placeholder="Email" value={this.state.email} />}
                    {stage === 2 && <Input type="text" placeholder="Телефон" value={this.state.phoneNumber} />}
                    {stage === 2 && <Input type="text" placeholder="Год рождения" value={this.state.dateOfBirth} />}
                    {stage === 2 && <Button type="button" onClick={this.handleIncrementStage.bind(this)} text="Далее" />}

                    {stage === 3 && <Input type="text" placeholder="Студент" value={this.state.student} />}
                    {stage === 3 && <Input type="text" placeholder="В каком вузе?" value={this.state.university} />}
                    {stage === 3 && <Input type="text" placeholder="Направление стажировки" value={this.state.internshipDirection} />}
                    {stage === 3 && <Button type="submit" onClick={this.handleIncrementStage.bind(this)} text="Поехали!" />}
                    {stage === 3 && <YesNoRadio question="Опыт работы" description="Волонтёрство, стажировка, работа по трудому договору"/>}

                </BasicForm>

                {
                    stage === 3 &&
                    <div className="my-7 max-w-sm mx-auto mb-20">
                    <p className="text-white text-opacity-20">
                        При нажатии на кнопку «Поехали!» вы принимаете соглашение об обработке персональных данных
                        и даете согласие на использование ваших персональных данных. Вы подтверждаете, что ознакомились с
                        политикой конфиденциальности и согласны с ее условиями.
                    </p>
                </div>
                }
                <div className="absolute bottom-0">

                    <svg className="w-full h-full" height="136" viewBox="0 0 720 136" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M549.5 95.6654C631 95.6654 687.674 103.674 720 136V418H0.3186L9.54626e-05 0.125246C0.085565 56.1861 57.5517 95.6654 127 95.6654H549.5Z" fill="#FF0F43"/>
                    </svg>
                </div>
            </div>
        );
    }
}