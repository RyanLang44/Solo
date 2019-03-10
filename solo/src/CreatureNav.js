import React, { Component } from 'react';
import logo from './logo.svg';
//import './CreatureNav.css';
import CreateCreature from './CreateCreature.js'
import UpdateCreature from './UpdateCreature.js'
import GetACreature from './GetACreature'
import DeleteCreature from './DeleteCreature';

class CreatureNav extends Component {
  constructor(props) {
    super(props);
    this.state = {
      option: ""
    }
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange = (event) => {
    this.setState({
      option: event.target.id
    });
  }

  render() {
    switch (this.state.option){
      
      case "create":
      return (
        <div className="CreatureNav">
          <button id="create" value={this.state.option} onClick={this.handleChange}>Create A Creature</button>
          <button id="getACreature" value={this.state.option} onClick={this.handleChange}>Get A Creature</button>
          <button id="update" value={this.state.option} onClick={this.handleChange}>Update A Creature</button>
          <button id="delete" value={this.state.option} onClick={this.handleChange}>Delete A Creature</button>
          <div id="pageContent">
            <CreateCreature/>
          </div>
        </div>
      );
      break;
      case "getACreature":
      return (
       <div className="CreatureNav">
          <button id="create" value={this.state.option} onClick={this.handleChange}>Create A Creature</button>
          <button id="getACreature" value={this.state.option} onClick={this.handleChange}>Get A Creature</button>
          <button id="update" value={this.state.option} onClick={this.handleChange}>Update A Creature</button>
          <button id="delete" value={this.state.option} onClick={this.handleChange}>Delete A Creature</button>
          <div id="pageContent">
            <GetACreature/>
          </div>
        </div>
      );
      break;
      case "update":
       return (
       <div className="CreatureNav">
          <button id="create" value={this.state.option} onClick={this.handleChange}>Create A Creature</button>
          <button id="getACreature" value={this.state.option} onClick={this.handleChange}>Get A Creature</button>
          <button id="update" value={this.state.option} onClick={this.handleChange}>Update A Creature</button>
          <button id="delete" value={this.state.option} onClick={this.handleChange}>Delete A Creature</button>
          <div id="pageContent">
            <UpdateCreature/>
          </div>
        </div>
      );
      break;
      case "delete":
      return (
       <div className="CreatureNav">
          <button id="create" value={this.state.option} onClick={this.handleChange}>Create A Creature</button>
          <button id="getACreature" value={this.state.option} onClick={this.handleChange}>Get A Creature</button>
          <button id="update" value={this.state.option} onClick={this.handleChange}>Update A Creature</button>
          <button id="delete" value={this.state.option} onClick={this.handleChange}>Delete A Creature</button>
          <div id="pageContent">
            <DeleteCreature/>
          </div>
        </div>
      );
      break;
      default:
       return (
       <div className="CreatureNav">
          <button id="create" value={this.state.option} onClick={this.handleChange}>Create A Creature</button>
          <button id="getACreature" value={this.state.option} onClick={this.handleChange}>Get A Creature</button>
          <button id="update" value={this.state.option} onClick={this.handleChange}>Update A Creature</button>
          <button id="delete" value={this.state.option} onClick={this.handleChange}>Delete A Creature</button>
          <div id="pageContent">
            
          </div>
        </div>
      );
      break;
      }
    }
}

export default CreatureNav;
