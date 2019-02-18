package com.qa.business.service;

public interface CreatureService {
	
	String addCharacter(String character);
	
	String getAllCharacters();
	
	String getACharacter(Long id);
	
	String updateCharacter(String character, Long id);
	
	String deleteCharacter(Long id);

}
