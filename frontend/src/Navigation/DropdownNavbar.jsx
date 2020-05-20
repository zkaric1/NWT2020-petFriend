import React, { Component } from 'react'
import 'react-dropdown/style.css';
import "react-datepicker/dist/react-datepicker.css";
import { Link } from "react-router-dom"

export class KnowledgeNavbar extends Component {

    render() {
        return (
            <nav className="navbar">
                <ul>
                    <li class="dropdown">
                        <Link to="/zivotinje">
                            <li class="dropbtn">Vještine</li>
                        </Link>
                        <div class="dropdown-content">
                            <Link to="/kreiraj-zivotinju">
                                <li>Tipovi vještina</li>
                            </Link>
                        </div>
                    </li>
                </ul>
            </nav >
        )
    }
}