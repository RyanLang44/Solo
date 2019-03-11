import React, { Component } from 'react';
import logo from './logo.svg';
import { Form, Field } from 'react-final-form';
import axios from 'axios';

class UpdateCreature extends Component{
    constructor(props) {
        super(props);
        this.state = {
            CreatureID: ''
        }
    };

    changeID = (e) => {
        this.setState({
            CreatureID: e.target.value
        });
        console.log(this.state.CreatureID);
    }

    updateCreature = (e) => {
        axios.get('http://35.197.234.211:8888/SoloProject/api/creature/getACreature/' + this.state.CreatureID)
        .then(response =>  {
            console.log(response.data);
            this.setState({
                data: response.data
            });

            
    
      
            document.getElementById('testid').innerHTML =  wordnice;  
            axios.delete('http://35.197.234.211:8888/SoloProject/api/creature/deleteCreature/' + this.state.CreatureID);
            

            axios.post('http://35.197.234.211:8888/SoloProject/api/creature/createCreature', {
                "charName" : document.getElementById('name').value,
                "hitPoints": document.getElementById('hitPoints').value,
                "magicPoints": document.getElementById('magicPoints').value,
                "attack": document.getElementById('attack').value,
                "magic": document.getElementById('magic').value,
                "speed": document.getElementById('speed').value,
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
                     Creature Name:
                     <br></br>
                     <input id="name" type="text" name="Name"></input>
                 </h4>
                 <h4>
                     Hit Points:
                     <br></br>
                     <input id="hitPoints" type="number" name="Hit Points"></input>
                 </h4>
                 <h4>
                    Magic Points:
                    <br></br>
                     <input id="magicPoints" type="number" name="Magic Points"></input>
                 </h4>
                 <h4>
                     Attack:
                     <br></br>
                     <input id="attack" type="number" name="Attack"></input>
                 </h4>
                 <h4>
                    Magic:
                 <br></br>
                     <input id="magic" type="number" name="Magic"></input>
                </h4>
                <h4>
                    Speed:
                <br></br>
                     <input id="speed" type="number" name="Speed"></input>
                </h4>
                {/* <h4>
                   Enter the ID of your Signature Move:
                <br></br>
                     <input id="move" type="number" name="move" onChange={this.changeID} ></input>
                </h4> */}
             </form>
             <br></br>
             <input type='submit' onClick={this.updateCreature} value="Update"></input>
             <br></br>
             
            </div>
        );
    }
}

export default UpdateCreature;