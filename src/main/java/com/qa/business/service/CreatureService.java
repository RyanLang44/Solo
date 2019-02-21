package com.qa.business.service;

public interface CreatureService {
	
	String addCreature(String creature);
	
	String getAllCreatures();
	
	String getACreature(Long id);
	
	String updateCreature(String creature, Long id);
	
	String deleteCreature(Long id);

}
