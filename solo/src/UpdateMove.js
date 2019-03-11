import React, { Component } from 'react';
import logo from './logo.svg';
import { Form, Field } from 'react-final-form';
import axios from 'axios';

class UpdateMove extends Component{
    constructor(props) {
        super(props);
        this.state = {
            MoveID: ''
        }
    };

    changeID = (e) => {
        this.setState({
            MoveID: e.target.value
        });
        console.log(this.state.MoveID);
    }

    updateMove = (e) => {
        axios.get('http://35.197.234.211:8888/SoloProject/api/move/getAMove/' + this.state.MoveID)
        .then(response =>  {
            console.log(response.data);
            this.setState({
                data: response.data
            });

            
    
      
            document.getElementById('testid').innerHTML =  wordnice;  
            axios.delete('http://35.197.234.211:8888/SoloProject/api/move/deleteMove/' + this.state.MoveID);
            

            axios.post('http://35.197.234.211:8888/SoloProject/api/move/createMove', {
                "moveName" : document.getElementById('moveName').value,
                "desc": document.getElementById('desc').value,
                "damage": document.getElementById('damage').value,
                "noOfTargets": document.getElementById('noOfTargets').value,
                "healing": document.getElementById('healing').value,
                "mpCost": document.getElementById('mpCost').value,
               // "moves": document.getElementById('move').value
            })
            .then(response => {
                console.log(response.data);
                console.log("Done");
            });
            
            let wordnice = JSON.stringify(response.data);
            wordnice = wordnice.replace('['," ");
            wordnice = wordnice.replace(']'," ");
            wordnice = wordnice.replace(/{/g," <divdis>");
            wordnice = wordnice.replace(/}/g," </divdis> </br>");
            wordnice = wordnice.replace(/\"/g, "");
            wordnice = wordnice.replace(/,/g,"<br/>");

            document.getElementById('testid').innerHTML =  wordnice;  

        });
    }

    render (){
        return(
            <div>
                <form>
                Enter the id of the creature you want to update:
                <input id="id" type="number" name="id" onChange={this.changeID} ></input>
                <h5 id='testid'></h5>
                 <h4>
                     Move Name:
                     <br></br>
                     <input id="moveName" type="text" name="Name"></input>
                 </h4>
                 <h4>
                     Description:
                     <br></br>
                     <input id="desc" type="text" name="Description"></input>
                 </h4>
                 <h4>
                    Damage:
                    <br></br>
                     <input id="damage" type="number" name="Damage"></input>
                 </h4>
                 <h4>
                     Number of Targets:
                     <br></br>
                     <input id="noOfTargets" type="number" name="Number of Targets"></input>
                 </h4>
                 <h4>
                    Healing:
                 <br></br>
                     <input id="healing" type="number" name="Healing"></input>
                </h4>
                <h4>
                    MP Cost:
                <br></br>
                     <input id="mpCost" type="number" name="mpCost"></input>
                </h4>
             </form>
             <br></br>
             <input type='submit' onClick={this.updateMove} value="Update"></input>
             <br></br>
             
            </div>
        );
    }
}

export default UpdateMove;