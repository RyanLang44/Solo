package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Move;
import com.qa.persistence.repository.MoveRepository;
import com.qa.util.JSONUtil;

public class MoveServiceImpl implements MoveService {

	@Inject
	private MoveRepository repo;
	 @Inject
	JSONUtil util;

	public MoveServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addMove(String move) {
		// TODO Auto-generated method stub
		Move newMove = util.getObjectForJSON(move, Move.class);
		int powerFormula = ((newMove.getDamage()+ newMove.getHealing())*newMove.getNoOfTargets())- newMove.getMpCost();
		
		if (powerFormula > 100) {
			return "This move is too powerful!";
		}
		
		return repo.createMove(move);
	}

	@Override
	public String getAllMoves() {
		// TODO Auto-generated method stub
		return repo.getAllMoves();
	}

	@Override
	public String getAMove(Long id) {
		// TODO Auto-generated method stub
		return repo.getAMove(id);
	}

	@Override
	public String updateMove(String move, Long id) {
		// TODO Auto-generated method stub
		return repo.updateMove(move, id);
	}

	@Override
	public String deleteMove(Long id) {
		// TODO Auto-generated method stub
		return repo.deleteMove(id);
	}

	public void setRepo(MoveRepository repo) {
		this.repo = repo;
	}


}
