import React from "react";
import {Logo} from "../component/Logo";
import {NavLink, useNavigate} from "react-router-dom";
import {MenuSpan} from "../component/MenuSpan";
import {ReactComponent as Home} from "../icons/home.svg";
import {ReactComponent as Work} from "../icons/work.svg";
import {ReactComponent as Support} from "../icons/support.svg";
import {ReactComponent as Info} from "../icons/info.svg";
import {ReactComponent as Logout} from "../icons/log-out.svg";

import authStore from "../stores/AuthStore";
import {UserType} from "../dto/UserType";

export function LeftMainMenu () {
    const navigate = useNavigate();

    const handleSignOut = () => {
        authStore.signOut();
        navigate('/');
    };


    return (
        <div className="fixed flex flex-col justify-between top-0 left-0 h-screen w-1/7 px-5">
            <div>
                <Logo />
                <ul className="text-white">
                    {authStore.userType === UserType.PARTICIPANT && (
                        <>
                            <li>
                                <NavLink to="/partic/center">
                                    {({ isActive, isPending }) => (
                                        <MenuSpan isActive={isActive} text="Центр управления" icon={Home} />
                                    )}
                                </NavLink>
                            </li>
                        </>
                    )}

                    {authStore.userType === UserType.SUPERVISOR && (
                        <>
                            <li>
                                <NavLink to="/supervisor/trainee">
                                    {({ isActive, isPending }) => (
                                        <MenuSpan isActive={isActive} text="Стажёры" icon={Work} />
                                    )}
                                </NavLink>
                            </li>
                        </>
                    )}

                    {authStore.userType === UserType.MENTOR && (
                        <>
                            <li>
                                <NavLink to="/mentor/internship">
                                    {({ isActive, isPending }) => (
                                        <MenuSpan isActive={isActive} text="Стажировка" icon={Work} />
                                    )}
                                </NavLink>
                            </li>
                        </>
                    )}
                </ul>
            </div>

            <div className="mb-20">
                <ul className="text-white">
                    <li>
                        <NavLink to="/support">
                            {({ isActive, isPending }) => (
                                <MenuSpan isActive={isActive} text="Поддежрка" icon={Support} />
                            )}
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/info">
                            {({ isActive, isPending }) => (
                                <MenuSpan isActive={isActive} text="Информация" icon={Info} />
                            )}
                        </NavLink>
                    </li>
                </ul>
                <button onClick={handleSignOut}>
                    <MenuSpan text="Выйти" icon={Logout} />
                </button>
            </div>
            <div className="fixed bottom-0 left-0 w-72">
                <svg className="w-full h-full" height="136" viewBox="0 0 720 136" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M549.5 95.6654C631 95.6654 687.674 103.674 720 136V418H0.3186L9.54626e-05 0.125246C0.085565 56.1861 57.5517 95.6654 127 95.6654H549.5Z" fill="#FF0F43" />
                </svg>
            </div>
        </div>
    );
}