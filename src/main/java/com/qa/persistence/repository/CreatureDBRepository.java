package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;


import com.qa.persistence.domain.Creature;
//import com.qa.business.service.RecipeService;
import com.qa.persistence.domain.Creature;
import com.qa.util.JSONUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Transactional(SUPPORTS)
@Default
public class CreatureDBRepository implements CreatureRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	public CreatureDBRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional(REQUIRED)
	public String createCreature(String creature) {
		// TODO Auto-generated method stub
		Creature newChar = util.getObjectForJSON(creature, Creature.class);
		manager.persist(newChar);
		return "{\"message\": \"Creature created.\"}";
	}
	
	
	public String getAllCreatures() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("Select a FROM Creature a");
		Collection<Creature> creatures = (Collection<Creature>) query.getResultList();
		return util.getJSONForObject(creatures);
	}
	
	
	public String getACreature(Long id) {
		// TODO Auto-generated method stub
		return util.getJSONForObject(manager.find(Creature.class, id));
	}
	
	@Transactional(REQUIRED)
	public String updateCreature(String creature, Long id) {
		Creature temp = new Creature();
		temp = util.getObjectForJSON(creature, Creature.class);
		manager.persist(temp);
		deleteCreature(id);
		return "{\"message\": \"Creature updated.\"}";
	}

	@Transactional(REQUIRED)
	public String deleteCreature(Long id) {
		// TODO Auto-generated method stub
		Creature creatureInDB = util.getObjectForJSON(getACreature(id), Creature.class);
		
		if (manager.contains(manager.find(Creature.class, id))) {
			manager.remove((manager.find(Creature.class, id)));
		}
		
		return "{\"message\": \"Creature deleted.\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
		
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
		
	}



}
