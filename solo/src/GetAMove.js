import React, { Component } from 'react';
import logo from './logo.svg';
import { Form, Field } from 'react-final-form';
import axios from 'axios';

class GetAMove extends Component{
    constructor(props){
        super(props);
        this.state = {
            MoveID: ''
        }
    }

    changeID = (e) => {
        this.setState({
            MoveID: e.target.value
        });
        console.log(this.state.MoveID);
    }

    getMove = (e) => {
        axios.get('http://localhost:8080/SoloProject/api/move/getAMove/' + this.state.MoveID)
        .then(response => {
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
        });
    }

    render (){
        return(
            <div>
                <form>
                    Enter the id of the  you want:
                <input id="id" type="number" name="id" onChange={this.changeID} ></input>
                <h5 id='testid'></h5>
                </form>
                <br></br>
                <input type='submit' onClick={this.getMove} value="Get"></input>
            </div>
        );
    }

}

export default GetAMove;