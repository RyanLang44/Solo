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

import com.qa.persistence.domain.Move;
import com.qa.persistence.domain.Move;
import com.qa.util.JSONUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


@Transactional(SUPPORTS)
public class MoveDBRepository implements MoveRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	public MoveDBRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional(REQUIRED)
	public String createMove(String move) {
		// TODO Auto-generated method stub
		Move newChar = util.getObjectForJSON(move, Move.class);
		manager.persist(newChar);
		return "{\"message\": \"Move created.\"}";
	}
	
	
	public String getAllMoves() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("Select a FROM move a");
		Collection<Move> moves = (Collection<Move>) query.getResultList();
		return util.getJSONForObject(moves);
	}
	
	
	public String getAMove(String moveName) {
		// TODO Auto-generated method stub
		return util.getJSONForObject(manager.find(Move.class, moveName));
	}
	
	@Transactional(REQUIRED)
	public String updateMove(String move, String moveName) {
		Move temp = new Move();
		temp = util.getObjectForJSON(move, Move.class);
		manager.persist(temp);
		deleteMove(moveName);
		return "{\"message\": \"Move updated.\"}";
	}

	@Transactional(REQUIRED)
	public String deleteMove(String moveName) {
		// TODO Auto-generated method stub
		Move moveInDB = util.getObjectForJSON(getAMove(moveName), Move.class);
		
		if (manager.contains(manager.find(Move.class, moveName))) {
			manager.remove((manager.find(Move.class, moveName)));
		}
		
		return "{\"message\": \"Move deleted.\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
		
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
		
	}
}
