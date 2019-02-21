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
	public String getACreature(@PathParam("id") Long id) {
		return service.getACreature(id);
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
	public String deleteCreature(@PathParam("id") Long id) {
		return service.deleteCreature(id);
	}
	
	@Path("/updateCreature/{id}")
	@PUT
	@Produces ({ "application/json" })
	public String updateCreature(@PathParam("id") Long id, String creatue) {
		
		return service.updateCreature(creatue, id);
	}
	
	public void setService(CreatureService service) {
		this.service = service;
	}
	
	

	

}
