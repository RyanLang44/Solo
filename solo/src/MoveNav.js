import React, { Component } from 'react';
import logo from './logo.svg';
//import './MoveNav.css';
import GetAMove from './GetAMove'
import DeleteMove from './DeleteMove'
import CreateMove from './CreateMove';
import UpdateMove from './UpdateMove';

class moveNav extends Component {
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
        <div className="MoveNav">
          <button id="create" value={this.state.option} onClick={this.handleChange}>Create A move</button>
          <button id="getAmove" value={this.state.option} onClick={this.handleChange}>Get A move</button>
          <button id="update" value={this.state.option} onClick={this.handleChange}>Update A move</button>
          <button id="delete" value={this.state.option} onClick={this.handleChange}>Delete A move</button>
          <div id="pageContent">
            <CreateMove/>
          </div>
        </div>
      );
      break;
      case "getAmove":
      return (
       <div className="MoveNav">
          <button id="create" value={this.state.option} onClick={this.handleChange}>Create A move</button>
          <button id="getAmove" value={this.state.option} onClick={this.handleChange}>Get A move</button>
          <button id="update" value={this.state.option} onClick={this.handleChange}>Update A move</button>
          <button id="delete" value={this.state.option} onClick={this.handleChange}>Delete A move</button>
          <div id="pageContent">
            <GetAMove/>
          </div>
        </div>
      );
      break;
      case "update":
       return (
       <div className="MoveNav">
          <button id="create" value={this.state.option} onClick={this.handleChange}>Create A move</button>
          <button id="getAmove" value={this.state.option} onClick={this.handleChange}>Get A move</button>
          <button id="update" value={this.state.option} onClick={this.handleChange}>Update A move</button>
          <button id="delete" value={this.state.option} onClick={this.handleChange}>Delete A move</button>
          <div id="pageContent">
            <UpdateMove/>
          </div>
        </div>
      );
      break;
      case "delete":
      return (
       <div className="MoveNav">
          <button id="create" value={this.state.option} onClick={this.handleChange}>Create A move</button>
          <button id="getAmove" value={this.state.option} onClick={this.handleChange}>Get A move</button>
          <button id="update" value={this.state.option} onClick={this.handleChange}>Update A move</button>
          <button id="delete" value={this.state.option} onClick={this.handleChange}>Delete A move</button>
          <div id="pageContent">
            <DeleteMove/>
          </div>
        </div>
      );
      break;
      default:
       return (
       <div className="MoveNav">
          <button id="create" value={this.state.option} onClick={this.handleChange}>Create A move</button>
          <button id="getAmove" value={this.state.option} onClick={this.handleChange}>Get A move</button>
          <button id="update" value={this.state.option} onClick={this.handleChange}>Update A move</button>
          <button id="delete" value={this.state.option} onClick={this.handleChange}>Delete A move</button>
          <div id="pageContent">
            
          </div>
        </div>
      );
      break;
      }
    }
}

export default moveNav;
