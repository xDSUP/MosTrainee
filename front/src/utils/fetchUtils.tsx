export const SERVER_URL = process.env.REACT_APP_SERVER_URL;

//Пример запроса на сервер
export function getHelloFromServer(){
    return fetch( `${SERVER_URL}/api/hello`).then(r => r.text()).catch(e => "ошибка запроса").then(console.log)
}