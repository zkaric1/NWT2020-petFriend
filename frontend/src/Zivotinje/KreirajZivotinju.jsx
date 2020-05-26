import React, { Component } from 'react'
import axios from 'axios'
import Select from 'react-select';
import FileBase64 from 'react-file-base64';

export class KreirajZivotinju extends Component {
    constructor(props) {
        super(props)
        this.state = {
            Zivotinje: [],
            spol: [
                { value: 'M', label: 'Muško'},
                { value: 'Z', label: 'Žensko'}
            ],
            velicina: [
                { value: 'Mali rast', label: 'Mali rast'},
                { value: 'Srednji rast', label: 'Srednji rast'},
                { value: 'Veliki rast', label: 'Veliki rast'},
            ],
            Ime:'',
            vrsta:'',
            rasa:'',
            odabraniSpol:'',
            godine:'',
            tezina:'',
            odabranaVelicina:'',
            slika:null,
            opis:''
        }
    }

    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }

    handleChangeSpol = (selectedOption) => {
        if (selectedOption) {
            this.setState({odabraniSpol:selectedOption.value});           
        }
    }

    handleChangeVelicina = (selectedOption) => {
        if (selectedOption) {
            this.setState({odabranaVelicina:selectedOption.value});
        }
    }

    KreirajZivotinju = () => {  
      var tempSlika =''
      tempSlika = this.state.slika[0].base64.substring(23, this.state.slika[0].base64.length)
      axios.post('http://localhost:8080/zivotinje', {
        ime: this.state.Ime,
        vrsta: this.state.vrsta,
        rasa: this.state.rasa,
        godine: Number(this.state.godine),
        udomljena: false,
        slika: tempSlika,
        spol: this.state.odabraniSpol,
        velicina: this.state.odabranaVelicina,
        dodatniOpis: this.state.opis,
        tezina: Number(this.state.tezina)
      }).catch(err => {
        console.log(err.response.data.message)
      })
      alert("Životinja je uspješno kreirana!")
    }

    getFiles(files){
      this.setState({ slika: files })
    }

    render() {
        return (
            <div className="wrapper">
              <div className="form-wrapper">
                <h1>Kreiraj životinju</h1>
                <form>
                  <div className="Ime">
                    <label htmlFor="Ime">Ime</label>
                    <input 
                      placeholder="Ime"
                      value={this.state.Ime}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="Ime"             
                    />                  
                  </div>
                  <div className="vrsta">
                    <label htmlFor="vrsta">Vrsta životinje</label>
                    <input                  
                      placeholder="Vrsta životinje"
                      value={this.state.vrsta}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="vrsta"             
                    />         
                  </div>
                  <div className="rasa">
                    <label htmlFor="rasa">Rasa</label>
                    <input                  
                      placeholder="Rasa"
                      type="text"
                      value={this.state.rasa}
                      onChange={e => this.handleChange(e)}
                      name="rasa"
                    />
                  </div>
                  <div className="godine">
                    <label htmlFor="godine">Godine</label>
                    <input  
                      placeholder="Godine"
                      value={this.state.godine}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="godine"  
                    />
                  </div>
                  <div className="spol">
                    <label htmlFor="spol">Spol</label>
                    <Select
                        options={this.state.spol}
                        onChange={(e) => {
                            this.handleChangeSpol(e);
                        }}
                        name="spol"
                    />                  
                  </div>
                  <div className="velicina">
                    <label htmlFor="velicina">Veličina</label>
                    <Select
                        options={this.state.velicina}
                        onChange={(e) => {
                            this.handleChangeVelicina(e);
                        }}
                        name="velicina"
                    />
                  </div>
                  <div className="tezina">
                    <label htmlFor="tezina">Težina</label>
                    <input  
                      placeholder="Težina"
                      value={this.state.tezina}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="tezina"
                    />
                  </div>
                  <div className="slikaA">
                    <label htmlFor="slika">Slika</label>
                    <FileBase64
                      multiple={ true }
                      onDone={ this.getFiles.bind(this) } />
                  </div>
                  <div className="opis">
                    <label htmlFor="opis">Dodatni opis</label>
                    <textarea
                      placeholder="Opis"
                      value={this.state.opis}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="opis"              
                    />
                  </div>      
                  <div className="kreiraj">
                    <button type="button" onClick={this.KreirajZivotinju}>Kreiraj životinju</button>                    
                  </div>
                </form>
              </div>
            </div>
          );
        }
    }
    
