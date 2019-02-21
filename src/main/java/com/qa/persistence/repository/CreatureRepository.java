package com.qa.persistence.repository;

public interface CreatureRepository {
	
	String createCreature(String creature);
	
	String getAllCreatures();
	
	String getACreature(Long id);
	
	String updateCreature(String creature, Long id);
	
	String deleteCreature(Long id);

}
