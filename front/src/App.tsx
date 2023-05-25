import React from 'react';
import './App.css';
import {LoginRegistrationPage} from "./page/LoginRegistrationPage";
import authStore from "./stores/AuthStore";
import {observer} from "mobx-react";
import {MainPage} from "./page/MainPage";

authStore.init();

export const App: React.FC = observer(() => {
  if (!authStore.isAuthorized) {
    return <div className="row w-25 mx-auto border-1">
      <LoginRegistrationPage></LoginRegistrationPage>
    </div>
  }
  return (
    <MainPage/>
  );
});

export default App;
