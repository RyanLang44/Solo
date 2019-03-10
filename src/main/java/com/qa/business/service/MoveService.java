package com.qa.business.service;

public interface MoveService {
	
	String addMove(String move);
	
	String getAllMoves();
	
	String getAMove(String moveName);
	
	String updateMove(String move, String moveName);
	
	String deleteMove(String moveName);
}
