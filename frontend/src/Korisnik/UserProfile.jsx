import React, { Component } from 'react'
import avatar from "./avatar.png"
import "./style.scss";
import axios from 'axios'
import { toast } from 'react-toastify';
import { Link } from "react-router-dom"

export class UserProfile extends Component {
    constructor(props) {
        super(props)
        this.state = {
            userId: '',
            userData: {},
            fullName: '',
            dateOfBirth: '',
            email: '',
            address: '',
            jmbg: '',
            gender: '',
        }
    }

    componentDidMount() {
        //procitat id
        axios.post(`http://localhost:8082/korisnik/${this.state.userId}`).then(
            res => {
                const userData = res.data;
                this.setState({ userData })
            }
        ).then(response => {
        }).catch(err => {
            toast.error(err.response.data.errors.toString(), { position: toast.POSITION.TOP_RIGHT })
        })
    }

    render() {
        return (
            <div className="parentProfile">
                <img src={avatar} />
                <div className="desnoDiv">
                    <Link to="/resetPassword">
                        <li className="linkProfile">Promijeni sifru</li>
                    </Link>
                </div>
                <div className="backgrDiv">
                    <div className="profileWrapper">


                        <div className="profileDiv">
                            <div className="userProfileLabelGroup">
                                <label><b>Ime i prezime:</b></label>
                                <label>Neko Nekic</label>
                            </div>
                            <div className="userProfileLabelGroup">
                                <label><b>Datum rodjenja:</b></label>
                                <label>06.03.1997</label>
                            </div>
                            <div className="userProfileLabelGroup">
                                <label><b>Email:</b></label>
                                <label>neko.nekic@hotmail.com</label>
                            </div>
                            <div className="userProfileLabelGroup">
                                <label><b>Adresa:</b></label>
                                <label>Bosanska bb</label>
                            </div>
                            <div className="userProfileLabelGroup">
                                <label><b>JMBG:</b></label>
                                <label>4567897654323456</label>
                            </div>
                            <div className="userProfileLabelGroup">
                                <label><b>Spol:</b></label>
                                <label>Musko</label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}