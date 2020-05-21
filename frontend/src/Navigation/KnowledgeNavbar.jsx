import React, { Component } from 'react'
import 'react-dropdown/style.css';
import "react-datepicker/dist/react-datepicker.css";
import { Link } from "react-router-dom"

export class KnowledgeNavbar extends Component {

    render() {
        return (
            <nav className="navbar">
                <ul>
                    <Link to="/zivotinje">
                        <li>Životinje</li>
                    </Link>
                    <Link to="/kreiraj-zivotinju">
                        <li>Kreiraj životinju</li>
                    </Link>
                    <Link to="/kreiraj-vakcinu">
                        <li>Kreiraj vakcinu</li>
                    </Link>
                    <Link to="/kreiraj-veterinara">
                        <li>Kreiraj veterinara</li>
                    </Link>  
                    <Link to="/kreiraj-bolest">
                        <li>Kreiraj bolest</li>
                    </Link>
                    <Link to="/login">
                        <li>Prijavi se</li>
                    </Link>
                </ul>
            </nav>
        )
    }
}