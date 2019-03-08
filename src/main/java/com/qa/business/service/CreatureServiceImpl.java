package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Creature;
import com.qa.persistence.repository.CreatureRepository;
import com.qa.util.JSONUtil;

public class CreatureServiceImpl implements CreatureService {

	@Inject
	private CreatureRepository repo;
	 @Inject
	JSONUtil util;

	public CreatureServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addCreature(String creature) {
		// TODO Auto-generated method stub
		Creature newChar = util.getObjectForJSON(creature, Creature.class);
		return repo.createCreature(creature);
	}

	@Override
	public String getAllCreatures() {
		// TODO Auto-generated method stub
		return repo.getAllCreatures();
	}

	@Override
	public String getACreature(String charName) {
		// TODO Auto-generated method stub
		return repo.getACreature(charName);
	}

	@Override
	public String updateCreature(String creature, String charName) {
		// TODO Auto-generated method stub
		return repo.updateCreature(creature, charName);
	}

	@Override
	public String deleteCreature(String charName) {
		// TODO Auto-generated method stub
		return repo.deleteCreature(charName);
	}

	public void setRepo(CreatureRepository repo) {
		this.repo = repo;
	}

}
