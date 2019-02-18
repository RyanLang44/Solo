package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Creature;
import com.qa.persistence.repository.CreatureRepository;
import com.qa.util.JSONUtil;

public class CreatureServiceImpl implements CreatureService {

	@Inject
	private CreatureRepository repo;
	// @Inject
	JSONUtil util = new JSONUtil();

	public CreatureServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addCharacter(String character) {
		// TODO Auto-generated method stub
		Creature newChar = util.getObjectForJSON(character, Creature.class);
		if ((newChar.getStatTotal()) > (newChar.getStatLimit())) {

			return "{\"message\": \"This creature is too powerful\"}";

		}

		return repo.createCharacter(character);
	}

	@Override
	public String getAllCharacters() {
		// TODO Auto-generated method stub
		return repo.getAllCharacters();
	}

	@Override
	public String getACharacter(Long id) {
		// TODO Auto-generated method stub
		return repo.getACharacter(id);
	}

	@Override
	public String updateCharacter(String character, Long id) {
		// TODO Auto-generated method stub
		return repo.updateCharacter(character, id);
	}

	@Override
	public String deleteCharacter(Long id) {
		// TODO Auto-generated method stub
		return repo.deleteCharacter(id);
	}

	public void setRepo(CreatureRepository repo) {
		this.repo = repo;
	}

}
