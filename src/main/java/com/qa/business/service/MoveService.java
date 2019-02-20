package com.qa.business.service;

public interface MoveService {
	
	String addMove(String move);
	
	String getAllMoves();
	
	String getAMove(Long id);
	
	String updateMove(String move, Long id);
	
	String deleteMove(Long id);
}
