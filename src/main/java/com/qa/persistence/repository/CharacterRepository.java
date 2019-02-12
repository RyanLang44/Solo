package com.qa.persistence.repository;

public interface CharacterRepository {
	
	String createCharacter(String character);
	
	String getAllCharacters();
	
	String getACharacter(Long id);
	
	String updateCharacter(String character, Long id);
	
	String deleteCharacter(Long id);

}
