import React from 'react';
import './App.css';
import { Zivotinje, KreirajZivotinju } from './Zivotinje/index'
import { KreirajVakcinu } from './Vakcine/index'
import { KreirajVeterinara } from './Veterinari/index'
import { KreirajBolest } from './Bolesti/index'
import { BrowserRouter as Router, Route, Switch } from "react-router-dom"
import { KnowledgeNavbar } from "./Navigation/index"
import {Login} from "./Korisnik/Login"

function App() {
  return (
    <Router>
      <div className="App">
        <KnowledgeNavbar />
        <Route path="/zivotinje" component={Zivotinje} />
        <Route path="/kreiraj-zivotinju" component={KreirajZivotinju} />
        <Route path="/kreiraj-vakcinu" component={KreirajVakcinu} />
        <Route path="/kreiraj-veterinara" component={KreirajVeterinara} />
        <Route path="/kreiraj-bolest" component={KreirajBolest} />
        <Route path="/login" component={Login}/>
      </div>
    </Router>
  );
}

export default App;
