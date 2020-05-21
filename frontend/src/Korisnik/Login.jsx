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
        this.setState({
            [this.state.email]: value
        })
    }

    setPassword = (value) => {
        this.setState({
            [this.state.password]: value
        })
    }

    validateForm = () => {
        console.log(this.state.email);

        this.valid = this.state.email.length > 0 && this.state.password.length > 0;
        return this.valid
    }

    userLogin = () => {
        if (!this.validateForm()) alert("Unesite vrijednosti")
        else {
            axios.post('http://localhost:8082/oauth/korisnik/prijava', {
                email: this.state.email,
                password: this.state.password,
            })
        }
    }

    handleSubmit = (event) => {
        event.preventDefault();
    }

    render() {
        return (
            <div className="userDiv">
                <form className="loginForma">
                    <label>Prijavi se</label>
                    <input 
                        className="loginInput" 
                        type="text" 
                        onChange={e => this.setEmail(e)} 
                        placeholder="Email" />
                    <input 
                        className="loginInput" 
                        type="password" 
                        onChange={e => this.setPassword(e)} 
                        placeholder="Sifra" />
                    <button 
                        className="loginButton" 
                        onClick={this.userLogin} 
                        type="submit"> Login</button>
                </form>
                <img src={loginSlika} alt="slika" />
            </div>
        )
    }
}