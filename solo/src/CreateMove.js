import React, { Component } from 'react';
import logo from './logo.svg';
//import './CreateMove.css';
import { Form, Field } from 'react-final-form';
import axios from 'axios';

class CreateMove extends Component{
    constructor(props) {
        super(props);
        this.state = {
          MoveID: '',  
          moveName: '',
          desc:'',
          damage:'',
          noOfTargets:'',
          healing:'',
          mpCost:'',
          
        }

        
    
      
        this.addRequest = (e) => {
            axios.post('http://localhost:8080/SoloProject/api/move/createMove', {
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
        };
      }
    


    render(){

     
        return(
         <div>
             <h3>Create your Move!</h3>
             <form>
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
             <input type='submit' onClick={this.addRequest} value="Add"></input>

        </div> 
        );
    }


    
}

export default CreateMove;



