package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.CreatureService;

@Path("/creature")
public class CreatureEndPoint {
	
	@Inject
	private CreatureService service;
	
	@Path("/getAllCharacters")
	@GET
	@Produces({ "application/json" })
	public String getAllCharacters() {
		return service.getAllCharacters();
	}
	
	@Path("/getACharacter/{id}")
	@GET
	@Produces ({ "application/json" })
	public String getACharacter(@PathParam("id") Long id) {
		return service.getACharacter(id);
	}
	
	@Path("/createCharacter")
	@POST 
	@Produces ({ "application/json" })
	public String addCharacter(String character) {
		return service.addCharacter(character);
	}
	
	@Path("/deleteCharacter/{id}")
	@DELETE
	@Produces ({ "application/json" })
	public String deleteCharacter(@PathParam("id") Long id) {
		return service.deleteCharacter(id);
	}
	
	@Path("/updateCharacter/{id}")
	@PUT
	@Produces ({ "application/json" })
	public String updateCharacter(@PathParam("id") Long id, String character) {
		
		return service.updateCharacter(character, id);
	}
	
	public void setService(CreatureService service) {
		this.service = service;
	}
	
	

	

}
