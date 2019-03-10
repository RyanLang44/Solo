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
	
	@Path("/getAllCreatures")
	@GET
	@Produces({ "application/json" })
	public String getAllCreatures() {
		return service.getAllCreatures();
	}
	
	@Path("/getACreature/{id}")
	@GET
	@Produces ({ "application/json" })
	public String getACreature(@PathParam("id") String charName) {
		return service.getACreature(charName);
	}
	
	@Path("/createCreature")
	@POST 
	@Produces ({ "application/json" })
	public String addCreature(String creatue) {
		return service.addCreature(creatue);
	}
	
	@Path("/deleteCreature/{id}")
	@DELETE
	@Produces ({ "application/json" })
	public String deleteCreature(@PathParam("id") String charName) {
		return service.deleteCreature(charName);
	}
	
	@Path("/updateCreature/{id}")
	@PUT
	@Produces ({ "application/json" })
	public String updateCreature(@PathParam("id") String charName, String creatue) {
		
		return service.updateCreature(creatue, charName);
	}
	
	public void setService(CreatureService service) {
		this.service = service;
	}
	
	

	

}
