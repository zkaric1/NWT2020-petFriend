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
                </ul>
            </nav>
        )
    }
}