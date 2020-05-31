import React, { Component } from 'react'
import loginSlika from "./login.png"
import "./style.scss";
import { toast } from 'react-toastify';
import axios from 'axios'

export class Register extends Component {
    constructor(props) {
        super(props)
        this.state = {
            uloge: [],
            spol: [
                { value: 'M', label: 'Muško' },
                { value: 'Z', label: 'Žensko' }
            ],
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

    componentDidMount() {
        axios.get('http://localhost:8082/uloga/lista').then(
            res => {
                const uloge = res.data
                this.setState({ uloge })
            }
        )
    }

    handleChangeSpol = (selectedOption) => {
        if (selectedOption) {
            this.setState({ gender: selectedOption.target.value });
        }
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
                        ? 'Ime i prezime mora imati vise od 5 slova!'
                        : '';
                break;
            case 'email':
                errors.email =
                    validEmailRegex.test(value)
                        ? ''
                        : 'Email format nije validan!';
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
        if (!this.validateForm(this.state.errors)) toast.error("Unesite vrijednosti", { position: toast.POSITION.TOP_RIGHT })
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
            }).then(response => {
                if (response.status === 200 || response.status === 201) toast.success('Uspješno kreiran racun', { position: toast.POSITION.TOP_RIGHT })
            }).catch(err => {
                toast.error(err.response.data.errors.toString(), { position: toast.POSITION.TOP_RIGHT })
            })
        }
    }

    render() {
        const { errors } = this.state
        return (
            <div className="userDiv">
                <form className="registerForma">
                    <label>Registruj se</label>
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
                            type="date"
                            onChange={e => this.handleChange(e)}
                            placeholder="Datum rodjenja"
                            name="dateOfBirth" />
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
                    <div className="inputGroup">
                        <input
                            className="loginInput"
                            type="text"
                            onChange={e => this.handleChange(e)}
                            placeholder="Adresa"
                            name="address" />
                        {errors.password.length > 0 &&
                            <span className='error'>{errors.address}</span>}
                    </div>
                    <div className="inputGroup">
                        <input
                            className="loginInput"
                            type="text"
                            onChange={e => this.handleChange(e)}
                            placeholder="JMBG"
                            name="jmbg" />
                        {errors.password.length > 0 &&
                            <span className='error'>{errors.jmbg}</span>}
                    </div>
                    <div className="selectWrapper">
                        <select className="selectBox"
                            onChange={(e) => {
                                this.handleChangeSpol(e);
                            }}
                            value={this.state.gender}
                            name="gender">
                            {this.state.spol.map(spol => <option key={spol.value} value={spol.value}>{spol.label}</option>)}
                        </select>
                    </div>
                    <div className="selectWrapper">
                        <select className="selectBox"
                            onChange={(e) => {
                                this.handleChangeUloga(e);
                            }}
                            value={this.state.role}
                            name="role">
                            {this.state.uloge.map(uloga => <option key={uloga.id} value={uloga.id}>{uloga.name}</option>)}
                        </select>
                    </div>
                    <button
                        className="loginButton"
                        onClick={e => this.userLogin(e)}
                        type="submit"> Registruj</button>
                </form>
            </div>
        )
    }
}