import React, { Component } from 'react';
import logo from './logo.svg';
//import './NavBar.css';
import CreatureNav from './CreatureNav.js';
import MoveNav from './MoveNav.js';

class NavBar extends Component {
 constructor(props){
   super(props);
   this.state= {
     display: "about"
   }
   this.handleChange = this.handleChange.bind(this);
 }

 handleChange = (event) => {
   this.setState({
     display: event.target.id
   });
 }
 
  render() {
   switch (this.state.display){
      case "about":
    
      return (
        <div className="NavBar">
          <button id="creatures" value={this.state.display} onClick={this.handleChange}>Creatures</button>
          <button id="moves" value={this.state.display} onClick={this.handleChange}>Moves</button>
          <button id="about" value={this.state.display} onClick={this.handleChange}>About</button>
          <div id="pageContent">
            <p> Welcome the the CreatureLab! </p>
            <p> Here you can browse the list of available monsters and techniques, as well as craft new ones</p>
            <p>Have fun!</p>
          </div>
        </div>
      );
      break;
      case "creatures":
         return (
        <div className="NavBar">
          <button id="creatures" value={this.state.display} onClick={this.handleChange}>Creatures</button>
          <button id="moves" value={this.state.display} onClick={this.handleChange}>Moves</button>
          <button id="about" value={this.state.display} onClick={this.handleChange}>About</button>
          <div id="pageContent">
            <CreatureNav/>
          </div>
        </div>
      );
      break;
      case "moves":
         return (
        <div className="NavBar">
          <button id="creatures" value={this.state.display} onClick={this.handleChange}>Creatures</button>
          <button id="moves" value={this.state.display} onClick={this.handleChange}>Moves</button>
          <button id="about"value={this.state.display} onClick={this.handleChange}>About</button>
           <div id="pageContent">
            <MoveNav/>
          </div>
        </div>
      );
      break;
      default:
         return (
        <div className="NavBar">
          <button id="creatures" value={this.state.display} onClick={this.handleChange}>Creatures</button>
          <button id="moves" value={this.state.display} onClick={this.handleChange}>Moves</button>
          <button id="about" value={this.state.display} onClick={this.handleChange}>About</button>
          <div id="pageContent">
            <p> Welcome the the CreatureLab! </p>
            <p> Here you can browse the list of available monsters and techniques, as well as craft new ones</p>
            <p>Have fun!</p>
          </div>
        </div>
      );
  }
}
}

export default NavBar;
