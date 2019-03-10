import React, { Component } from 'react';
import logo from './logo.svg';
import { Form, Field } from 'react-final-form';
import axios from 'axios';

class DeleteCreature extends Component{
    constructor(props) {
        super(props);
        this.state = {
            CreatureName: ''
        }
    };
    changeID = (e) => {
        this.setState({
            CreatureID: e.target.value
        });
        console.log(this.state.CreatureID);
    }

    deleteCreature = (e) => {
        axios.get('http://localhost:8080/SoloProject/api/creature/getACreature/' + this.state.CreatureID)
        .then(response =>  {
            console.log(response.data);
            this.setState({
                data: response.data
            });

            let wordnice = JSON.stringify(response.data);
            wordnice = wordnice.replace('['," ");
            wordnice = wordnice.replace(']'," ");
            wordnice = wordnice.replace(/{/g," <divdis>");
            wordnice = wordnice.replace(/}/g," </divdis> </br>");
            wordnice = wordnice.replace(/\"/g, "");
            wordnice = wordnice.replace(/,/g,"<br/>");
    
      
            document.getElementById('testid').innerHTML =  wordnice;  
            axios.delete('http://localhost:8080/SoloProject/api/creature/deleteCreature/' + this.state.CreatureID);
            document.getElementById('deletedMessage').innerHTML = "Creature Deleted";

        });
    }

    render (){
        return(
            <div>
                <form>
                    Enter the id of the creature you want to delete:
                <input id="id" type="number" name="id" onChange={this.changeID} ></input>
                <h5 id='testid'></h5>
                <h5 id='deletedMessage'></h5>
                </form>
                <br></br>
                <input type='submit' onClick={this.deleteCreature} value="Delete"></input>
            </div>
        );
    }

}

export default DeleteCreature;
