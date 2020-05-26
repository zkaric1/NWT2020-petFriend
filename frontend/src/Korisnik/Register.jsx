import React, { Component } from 'react'
import loginSlika from "./login.png"
import "./style.scss";
import axios from 'axios'

export class Register extends Component {
    constructor(props) {
        super(props)
        this.state = {
            fullName: '',
            dateOfBirth: '',
            email: '',
            password: '',
            address: '',
            jmbg: '',
            gender: '',
            role: '',
            errors: {
                fullName: '',
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
              case 'fullName': 
                errors.fullName = 
                  value.length < 5
                    ? 'Full Name must be 5 characters long!'
                    : '';
                break;
            case 'email':
                errors.email =
                    validEmailRegex.test(value)
                        ? ''
                        : 'Email is not valid!';
                break;
            case 'password':
                errors.password =
                    value.length < 8
                        ? 'Password must be 8 characters long!'
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
            axios.post('http://localhost:8082/oauth/korisnik', {
                fullName: this.state.fullName,
                dateOfBirth: this.state.dateOfBirth,
                email: this.state.email,
                password: this.state.password,
                address: this.state.address,
                jmbg: this.state.jmbg,
                gender: this.state.gender,
                role: this.state.role

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
                            type="text"
                            onChange={e => this.handleChange(e)}
                            placeholder="Ime i prezime"
                            name="fullName" />
                        {errors.email.length > 0 &&
                            <span className='error'>{errors.fullName}</span>}
                    </div>
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
                        type="submit"> Login</button>
                </form>
                <img src={loginSlika} alt="slika" />
            </div>
        )
    }
}