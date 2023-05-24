import React from 'react';
import './App.css';
import {LoginRegistrationPage} from "./page/LoginRegistrationPage";
import {getHelloFromServer} from "./utils/fetchUtils";

function App() {
  getHelloFromServer()

  return (
    <LoginRegistrationPage/>
  );
}

export default App;
