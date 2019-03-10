package com.qa.persistence.repository;

public interface MoveRepository {

String createMove(String move);
	
	String getAllMoves();
	
	String getAMove(String moveName);
	
	String updateMove(String move, String moveName);
	
	String deleteMove(String moveName);
	
}
