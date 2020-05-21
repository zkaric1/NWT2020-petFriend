import React, { Component } from 'react'
import "./style.scss";

export class Login extends Component {
    constructor(props) {
        super(props)
        this.state = {
            email: '',
            password: ''
        }
    }

    setEmail = (value) => {
        this.state.email = value
    }

    setPassword = (value) => {
        this.state.password = value
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
                <img src="login.png" alt="backgroound"></img>
            <form  className="loginForma" onSubmit={this.handleSubmit}>
                <label>Prijavi se</label>
                <input className="loginInput" name="email" type="text" placeholder="Email" />
                <input  className="loginInput" name="password" type="password" placeholder="Sifra"/>
                <button className="loginButton"  type="submit"> Login</button>
            </form>
            </div>
        )
    }
}