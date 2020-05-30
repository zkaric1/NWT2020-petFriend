import React, { Component } from 'react'
import 'react-dropdown/style.css';
import "react-datepicker/dist/react-datepicker.css";
import { Link } from "react-router-dom";
import { NavLink } from 'react-router-dom';

export class KnowledgeNavbar extends Component {

    render() {
        return (
            <nav className="navbar">
                <ul>
                    <Link to="/zivotinje">
                        <li className="link-wrapper" activeClassName="active">Životinje</li>
                    </Link>
                    <Link to="/kreiraj-zivotinju">
                        <li className="link-wrapper" activeClassName="active">Kreiraj životinju</li>
                    </Link>
                    <Link to="/kreiraj-vakcinu">
                        <li className="link-wrapper" activeClassName="active">Kreiraj vakcinu</li>
                    </Link>
                    <Link to="/kreiraj-veterinara">
                        <li className="link-wrapper" activeClassName="active">Kreiraj veterinara</li>
                    </Link>  
                    <Link to="/kreiraj-bolest">
                        <li className="link-wrapper" activeClassName="active">Kreiraj bolest</li>
                    </Link>
                    <Link to="/login">
                        <li>Prijavi se</li>
                    </Link>
                
                    <Link to="/userProfile">
                        <li>Profil</li>
                    </Link>
                </ul>
            </nav>
        )
    }
}