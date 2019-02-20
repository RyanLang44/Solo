package com.qa.persistence.repository;

public interface MoveRepository {

String createMove(String move);
	
	String getAllMoves();
	
	String getAMove(Long id);
	
	String updateMove(String move, Long id);
	
	String deleteMove(Long id);
	
}
