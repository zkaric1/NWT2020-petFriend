import React, { Component } from 'react'
import loginSlika from "./login.png"
import "./style.scss";
import axios from 'axios'
import { Link, useHistory } from "react-router-dom"

export class Login extends Component {
    constructor(props) {
        super(props)
        this.state = {
            email: '',
            password: '',
            errors: {
                email: '',
                password: ''
            }
        }
    }

    validateForm = (errors) => {
        let valid = true;
        Object.values(errors).forEach(
            // if we have an error string set valid to false
            (val) => val.length > 0 && (valid = false)
        );
        return valid;
    }

    handleChange = (event) => {
        const validEmailRegex =
            RegExp(/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i);
        event.preventDefault();
        const { name, value } = event.target;
        let errors = this.state.errors;

        switch (name) {
            case 'email':
                errors.email =
                    validEmailRegex.test(value)
                        ? ''
                        : 'Email format nije validan';
                break;
            case 'password':
                errors.password =
                    value.length < 8
                        ? 'Sifra mora imati najmanje 8 karaktera!'
                        : '';
                break;
            default:
                break;
        }

        this.setState({ errors, [name]: value }, () => {
            console.log(errors)
        })
    }

    userLogin = (event) => {
        event.preventDefault();
        if (!this.validateForm(this.state.errors)) alert("Unesite vrijednosti")
        else {
            axios.post('http://localhost:8082/oauth/korisnik/prijava', {
                email: this.state.email,
                password: this.state.password,

            })
        }
    }

    render() {
        const { errors } = this.state
        return (
            <div className="userDiv">
                <form className="loginForma">
                    <label>Prijavi se</label>
                    <div className="inputGroup">
                        <input
                            className="loginInput"
                            type="email"
                            onChange={e => this.handleChange(e)}
                            placeholder="Email"
                            name="email" />
                        {errors.email.length > 0 &&
                            <span className='error'>{errors.email}</span>}
                    </div>
                    <div className="inputGroup">
                        <input
                            className="loginInput"
                            type="password"
                            onChange={e => this.handleChange(e)}
                            placeholder="Sifra"
                            name="password" />
                        {errors.password.length > 0 &&
                            <span className='error'>{errors.password}</span>}
                    </div>
                    <button
                        className="loginButton"
                        onClick={e => this.userLogin(e)}
                        type="submit"> Prijava
                        </button>
                </form>
                <div className="goToRegisterDiv">
                    <label>Nemate racun?</label>
                <Link className="linkRegister" to="/register">
                        <li>Registruj se</li>
                    </Link>
                </div>
                <img
                    className="loginImg"
                    src={loginSlika}
                    alt="slika" />
            </div>
        )
    }
}