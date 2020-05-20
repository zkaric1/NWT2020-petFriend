import React, { Component } from 'react'
import axios from 'axios'

export class Zivotinje  extends Component {
    constructor(props) {
        super(props)
        this.state = {
            Zivotinje: []
        }
    }

    componentWillMount() {
        axios.get('http://localhost:8080/zivotinje')
          .then(res => {
            const Zivotinje = res.data;
            this.setState({ Zivotinje });
        })  
      }
    
    render() {
        return(
            <div className="App">
                <div className="zivotinje">
                    {this.state.Zivotinje && this.state.Zivotinje.map((zivotinja, index) => {
                        var spolTemp ="Žensko"
                        var udomljenaTemp = "Nije udomljena"
                        if (zivotinja.spol == 'M') spolTemp = "Muško"
                        if (zivotinja.udomljena) udomljenaTemp = "Udomljena"
                        return (
                        <div className="zivotinja" key={index}>
                            <h2>{zivotinja.ime}</h2>
                            <div className="detalji">
                                <p> Vrsta: {zivotinja.vrsta}</p>
                                <p> Rasa: {zivotinja.rasa} </p>
                                <p> Godine: {zivotinja.godine}</p>
                                <p> Spol: {spolTemp}</p>
                                <p> Veličina: {zivotinja.velicina}</p>
                                <p> Težina: {zivotinja.tezina}</p>                       
                                <p> Dodatni opis: {zivotinja.dodatniOpis}</p>
                                <p> Udomljena: {udomljenaTemp}</p>
                            </div>
                            <div className="slika">
                                <img src={`data:image/jpeg;base64,${zivotinja.slika}`} />
                            </div>

                        </div>
                        );
                    })}
                 </div>
            </div>
        )
    }
}


