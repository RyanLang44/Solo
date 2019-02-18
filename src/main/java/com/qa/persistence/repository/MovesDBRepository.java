package com.qa.persistence.repository;

import java.util.Collection;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Moves;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class MovesDBRepository implements MovesRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	
	
	
	public String createMove(String move) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getAllMoves() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("Select a FROM move a");
		Collection<Moves> moves = (Collection<Moves>) query.getResultList();
		return util.getJSONForObject(moves);
	}

	public String getAMove(Long id) {
		// TODO Auto-generated method stub
		return util.getJSONForObject(manager.find(Moves.class, id));
	}

	public String updateMove(String move, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteMove(Long id) {
		// TODO Auto-generated method stub
		Moves moveInDB = util.getObjectForJSON(getAMove(id), Moves.class);
		
		if (manager.contains(manager.find(Moves.class, id))) {
			manager.remove((manager.find(Moves.class, id)));
		}
		
		return "{\"message\": \"move successfully deleted\"}";
	}




}
