import React, { Component } from 'react'
import axios from 'axios'

export class KreirajVakcinu extends Component {
    constructor(props) {
        super(props)
        this.state = {
            tip:'',
            revakcinacija:''
        }
    }

    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }

    kreirajVakcinu = () => {   
        axios.post('http://localhost:8080/vakcine', {
            tip: this.state.tip,
            revakcinacija: Number(this.state.revakcinacija),
        })
        alert("Vakcina je uspješno kreirana!")
    }

    render() {
        return (
            <div className="wrapper">
              <div className="form-wrapper">
                <h1>Kreiraj vakcinu</h1>
                <form>
                  <div className="tip">
                    <label htmlFor="tip">Tip vakcine</label>
                    <input 
                      placeholder="Tip"
                      value={this.state.tip}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="tip"             
                    />                  
                  </div>
                  <div className="revakcinacija">
                    <label htmlFor="revakcinacija">Period revakcinacije</label>
                    <input                  
                      placeholder="Revakcinacija"
                      value={this.state.revakcinacija}
                      onChange={e => this.handleChange(e)}
                      type="text"
                      name="revakcinacija"             
                    />         
                  </div>
                  <div className="kreiraj">
                    <button type="submit" onClick={this.kreirajVakcinu}>Kreiraj vakcinu</button>                    
                  </div>
                </form>
              </div>
            </div>
        );
    }
}
    
