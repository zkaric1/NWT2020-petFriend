import React, { Component } from 'react'
import axios from 'axios'

export class KreirajBolest extends Component {
    constructor(props) {
        super(props)
        this.state = {
            ime:'',
            lijek:''
        }
    }

    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }

    kreirajVakcinu = () => {   
        axios.post('http://localhost:8080/bolesti', {
            ime: this.state.ime,
            lijek: this.state.lijek,
        })
        alert("Bolest je uspješno kreirana!")
    }

    render() {
        return (
            <div className="wrapper">
              <div className="form-wrapper">
                <h1>Kreiraj bolest</h1>
                <form>
                  <div className="ime">
                    <label htmlFor="ime">Ime bolesti</label>
                    <input 
                      placeholder="Ime"
                      value={this.state.ime}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="ime"             
                    />                  
                  </div>
                  <div className="lijek">
                    <label htmlFor="lijek">Lijek</label>
                    <input                  
                      placeholder="Lijek"
                      value={this.state.lijek}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="lijek"             
                    />         
                  </div>
                  <div className="kreiraj">
                    <button type="submit" onClick={this.kreirajVakcinu}>Kreiraj bolest</button>                    
                  </div>
                </form>
              </div>
            </div>
        );
    }
}
    
