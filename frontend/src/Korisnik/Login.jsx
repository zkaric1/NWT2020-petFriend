import React, { Component } from 'react'
import { Button, FormGroup, FormControl, ControlLabel, FormLabel } from "react-bootstrap";
import "./login.module.css";

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
            // <div className="Login">
            //     <form onSubmit={this.handleSubmit}>
            //         <FormGroup controlId="email" bsSize="large">
            //             <FormLabel>Email</FormLabel>
            //             <FormControl
            //                 autoFocus
            //                 type="email"
            //                 value={this.state.email}
            //                 onChange={e => this.setEmail(e.target.value)}
            //             />
            //         </FormGroup>
            //         <FormGroup controlId="password" bsSize="large">
            //             <FormLabel>Password</FormLabel>
            //             <FormControl
            //                 value={this.state.password}
            //                 onChange={e => this.setPassword(e.target.value)}
            //                 type="password"
            //             />
            //         </FormGroup>
            //         <Button block bsSize="large" disabled={!this.validateForm()} type="submit">
            //             Login
            // </Button>
            //     </form>
            // </div>
            <div>
                <img src="login.png" alt="backgroound"></img>
            <form onSubmit={this.handleSubmit}>
                <label>Prijavi se</label>
                <input name="email" type="text" placeholder="Email" />
                <input name="password" type="password" placeholder="Sifra"/>
                <button type="submit"> Login</button>
            </form>
            </div>
        )
    }
}