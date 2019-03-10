package com.qa.business.service;

public interface CreatureService {
	
	String addCreature(String creature);
	
	String getAllCreatures();
	
	String getACreature(String charName);
	
	String updateCreature(String creature, String charName);
	
	String deleteCreature(String charName);

}
