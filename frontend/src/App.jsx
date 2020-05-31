import React from 'react';
import './App.css';
import { Zivotinje, KreirajZivotinju } from './Zivotinje/index'
import { KreirajVakcinu } from './Vakcine/index'
import { KreirajVeterinara } from './Veterinari/index'
import { KreirajBolest } from './Bolesti/index'
import { BrowserRouter as Router, Route, Switch } from "react-router-dom"
import { AdminNavbar } from "./Navigation/index"
import {Login} from "./Korisnik/Login"
import {Register} from "./Korisnik/Register"
import {ResetPassword} from "./Korisnik/ResetPassword"
import {UserProfile} from "./Korisnik/UserProfile"
import {Admin} from './Paneli/Admin'
import {Korisnik} from './Paneli/Korisnik'

function App() {
  return (
    <Router>
      <div className="App">
        <Route path="/" exact component={Login}/>
        <Route path="/admin" component={Admin} />
        <Route path="/korisnik" component={Korisnik} />
        <Route path="/register" component={Register}/>
      </div>
    </Router>
  );
}

export default App;
