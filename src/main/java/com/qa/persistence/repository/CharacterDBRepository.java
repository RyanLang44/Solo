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

import com.qa.persistence.domain.Character;
//import com.qa.business.service.RecipeService;
import com.qa.persistence.domain.Character;
import com.qa.util.JSONUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Transactional(SUPPORTS)
@Default
public class CharacterDBRepository implements CharacterRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	public CharacterDBRepository() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String createCharacter(String character) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getAllCharacters() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("Select a FROM character a");
		Collection<Character> characters = (Collection<Character>) query.getResultList();
		return util.getJSONForObject(characters);
	}

	public String getACharacter(Long id) {
		// TODO Auto-generated method stub
		return util.getJSONForObject(manager.find(Character.class, id));
	}

	public String updateCharacter(String character, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteCharacter(Long id) {
		// TODO Auto-generated method stub
		Character characterInDB = util.getObjectForJSON(getACharacter(id), Character.class);
		
		if (manager.contains(manager.find(Character.class, id))) {
			manager.remove((manager.find(Character.class, id)));
		}
		
		return "{\"message\": \"character successfully deleted\"}";
	}

}
