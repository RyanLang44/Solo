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
		
		if(newChar.getHitPoints() + newChar.getMagicPoints() + newChar.getAttack() + newChar.getMagic() + newChar.getSpeed() > 60) {
			return "This creature is too strong!";
		}
		
		return repo.createCreature(creature);
	}

	@Override
	public String getAllCreatures() {
		// TODO Auto-generated method stub
		return repo.getAllCreatures();
	}

	@Override
	public String getACreature(Long id) {
		// TODO Auto-generated method stub
		return repo.getACreature(id);
	}

	@Override
	public String updateCreature(String creature, Long id) {
		// TODO Auto-generated method stub
		return repo.updateCreature(creature, id);
	}

	@Override
	public String deleteCreature(Long id) {
		// TODO Auto-generated method stub
		return repo.deleteCreature(id);
	}

	public void setRepo(CreatureRepository repo) {
		this.repo = repo;
	}

}
