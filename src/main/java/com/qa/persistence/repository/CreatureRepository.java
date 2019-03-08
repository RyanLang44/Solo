package com.qa.persistence.repository;

public interface CreatureRepository {
	
	String createCreature(String creature);
	
	String getAllCreatures();
	
	String getACreature(String charName);
	
	String updateCreature(String creature, String charName);
	
	String deleteCreature(String charName);

}
