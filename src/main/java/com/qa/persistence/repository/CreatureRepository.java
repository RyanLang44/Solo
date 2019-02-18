package com.qa.persistence.repository;

public interface CreatureRepository {
	
	String createCharacter(String character);
	
	String getAllCharacters();
	
	String getACharacter(Long id);
	
	String updateCharacter(String character, Long id);
	
	String deleteCharacter(Long id);

}
