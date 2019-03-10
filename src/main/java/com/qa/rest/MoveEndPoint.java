package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.MoveService;
import com.qa.business.service.MoveService;


@Path("/move")
public class MoveEndPoint {
	@Inject
	private MoveService service;
	
	@Path("/getAllMoves")
	@GET
	@Produces({ "application/json" })
	public String getAllMoves() {
		return service.getAllMoves();
	}
	
	@Path("/getAMove/{id}")
	@GET
	@Produces ({ "application/json" })
	public String getAMove(@PathParam("id") String moveName) {
		return service.getAMove(moveName);
	}
	
	@Path("/createMove")
	@POST 
	@Produces ({ "application/json" })
	public String addMove(String move) {
		return service.addMove(move);
	}
	
	@Path("/deleteMove/{id}")
	@DELETE
	@Produces ({ "application/json" })
	public String deleteMove(@PathParam("id") String moveName) {
		return service.deleteMove(moveName);
	}
	
	@Path("/updateMove/{id}")
	@PUT
	@Produces ({ "application/json" })
	public String updateMove(@PathParam("id") String moveName, String move) {
		
		return service.updateMove(move, moveName);
	}
	
	public void setService(MoveService service) {
		this.service = service;
	}
	

}
