import React, { Component } from 'react'
import axios from 'axios'

export class KreirajZivotinju extends Component {
    constructor(props) {
        super(props)
        this.state = {
            Korisnici : [
                {Tema: "", Host: "", Vrijeme: "", Tip_Edukacije: "", Vještina: "", obrisati: false}
            ],
            Zivotinje: []
        }
    }

    componentWillMount() {
        axios.get("http://localhost:8080/zivotinje").then(res => {
            const Zivotinje = res.data
            this.setState(
                    { Zivotinje }
                )
        })
    }

    headerTabele() {
        let header = Object.keys(this.state.Korisnici[0])
        return header.map((key, index) => {
           return <th key={index}>{key.toUpperCase()}</th>
        })
    }

    render() {
        return (
            <div className="wrapper">
              <div className="form-wrapper">
                <h1>Kreiraj životinju</h1>
                <form onSubmit={this.handleSubmit} noValidate>
                  <div className="Ime">
                    <label htmlFor="Ime">Ime</label>
                    <input 
                      placeholder="Ime"
                      type="text"
                      name="Ime"
                      noValidate
                    />
                   
                  </div>
                  <div className="vrsta">
                    <label htmlFor="vrsta">Vrsta životinje</label>
                    <input                  
                      placeholder="Vrsta životinje"
                      type="text"
                      name="vrsta"
                      noValidate              
                    />
                   
                  </div>
                  <div className="rasa">
                    <label htmlFor="rasa">Rasa</label>
                    <input                  
                      placeholder="Rasa"
                      type="text"
                      name="rasa"
                      noValidate
                    />
                  </div>
                  <div className="godine">
                    <label htmlFor="godine">Godine</label>
                    <input  
                      placeholder="Godine"
                      type="text"
                      name="godine"
                      noValidate     
                    />
                  </div>
                  <div className="spol">
                    <label htmlFor="spol">Spol</label>
                    <input  
                      placeholder="Spol"
                      type="text"
                      name="spol"
                      noValidate                   
                    />
                  </div>
                  <div className="velicina">
                    <label htmlFor="velicina">Veličina</label>
                    <input  
                      placeholder="Veličina"
                      type="text"
                      name="velicine"
                      noValidate                     
                    />
                  </div>
                  <div className="tezina">
                    <label htmlFor="tezina">Težina</label>
                    <input  
                      placeholder="Težina"
                      type="text"
                      name="tezina"
                      noValidate
                    />
                  </div>
                  <div className="slika">
                    <label htmlFor="slika">Slika</label>
                    <input  
                      placeholder="Slika"
                      type="text"
                      name="slika"
                      noValidate                   
                    />
                  </div>
                  <div className="opis">
                    <label htmlFor="opis">Dodatni opis</label>
                    <textarea
                      placeholder="Opis"
                      type="text"
                      name="opis"
                      noValidate                
                    />
                  </div>
                  <div className="kreiraj">
                    <button type="submit">Kreiraj životinju</button>
                    
                  </div>
                </form>
              </div>
            </div>
          );
        }
    }
    
