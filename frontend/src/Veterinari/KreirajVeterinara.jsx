import React, { Component } from 'react'
import axios from 'axios'

export class KreirajVeterinara extends Component {
    constructor(props) {
        super(props)
        this.state = {
            ime:'',
            prezime:'',
            adresa:'',
            telefon:''
        }
    }

    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }

    kreirajVeterinara = () => {   
        axios.post('http://localhost:8080/veterinari', {
            ime: this.state.ime,
            prezime: this.state.prezime,
            adresa: this.state.adresa,
            kontaktTelefon: this.state.telefon,
        })
        alert("Veterinar je uspješno kreiran!")
    }

    render() {
        return (
            <div className="wrapper">
              <div className="form-wrapper">
                <h1>Kreiraj veterinara</h1>
                <form>
                  <div className="ime">
                    <label htmlFor="ime">Ime</label>
                    <input 
                      placeholder="Ime"
                      value={this.state.ime}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="ime"             
                    />                  
                  </div>
                  <div className="prezime">
                    <label htmlFor="prezime">Prezime</label>
                    <input                  
                      placeholder="Prezime"
                      value={this.state.prezime}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="prezime"             
                    />         
                  </div>
                  <div className="adresa">
                    <label htmlFor="adresa">Adresa ordinacije</label>
                    <input                  
                      placeholder="Adresa"
                      value={this.state.adresa}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="adresa"             
                    />         
                  </div>
                  <div className="telefon">
                    <label htmlFor="telefon">Kontakt telefon</label>
                    <input                  
                      placeholder="Kontakt telefon"
                      value={this.state.telefon}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="telefon"             
                    />         
                  </div>
                  <div className="kreiraj">
                    <button type="submit" onClick={this.kreirajVeterinara}>Unesi podatke o veterinaru</button>                    
                  </div>
                </form>
              </div>
            </div>
        );
    }
}
    
