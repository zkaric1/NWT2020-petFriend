import React, { Component } from 'react'
import loginSlika from "./login.png"
import "./style.scss";
import axios from 'axios'

export class Login extends Component {
    constructor(props) {
        super(props)
        this.state = {
            email: '',
            password: ''
        }
    }

    setEmail = (value) => {
        this.setState.email = value
    }

    setPassword = (value) => {
        this.setState.password = value
    }

    validateForm = () => {
        return this.state.email.length > 0 && this.state.password.length > 0;
    }

    handleSubmit = (event) => {
        event.preventDefault();
    }

    render() {
        return (
            <div className="userDiv">
                <form className="loginForma" onSubmit={this.handleSubmit}>
                    <label>Prijavi se</label>
                    <input className="loginInput" type="text" value={this.state.email} onChange={e => this.setEmail(e)} placeholder="Email" />
                    <input className="loginInput" type="password" value={this.state.password} onChange={e => this.setPassword(e)} placeholder="Sifra" />
                    <button className="loginButton" disabled={!this.validateForm()} type="submit"> Login</button>
                </form>
                <img src={loginSlika} alt="slika" />
            </div>
        )
    }
}