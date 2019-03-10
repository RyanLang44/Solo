package com.qa.persistence.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.util.JSONUtil;
import com.qa.persistence.domain.Move;
import com.qa.persistence.domain.Move;

@RunWith(MockitoJUnitRunner.class)
public class MoveDBRepositoryTest {

	@InjectMocks
	private MoveDBRepository repo;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	private static final String MOCK_OBJECT = "{\"moveName\":\"Flame Breath\",\"desc\":\"fire comes out of mouth\",\"damage\":10,\"noOfTargets\":5,\"healing\":0,\"mpCost\":5}";
	
	private static final String MOCK_DATA_ARRAY ="[{\"moveName\":\"Flame Breath\",\"desc\":\"fire comes out of mouth\",\"damage\":10,\"noOfTargets\":5,\"healing\":0,\"mpCost\":5}]";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	
	@Test
	public void testGetAllMoves() {
		Move test1 = new Move("Flame Breath", "fire comes out of mouth", 10, 5, 0, 5);
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Move> moves = new ArrayList<Move>();
		moves.add(test1);
		Mockito.when(query.getResultList()).thenReturn(moves);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllMoves());
	}
	
	@Test
	public void testGetAMove() {
	Mockito.when(manager.find(Move.class, "Flame Breath")).thenReturn(util.getObjectForJSON(MOCK_OBJECT, Move.class));
	assertEquals(MOCK_OBJECT, repo.getAMove("Flame Breath"));
	}
	
	@Test
	public void testCreateMove() {
		String reply = repo.createMove(MOCK_OBJECT);
		assertEquals(reply,"{\"message\": \"Move created.\"}");
	}
	
	@Test
	public void testDeleteMove() {
		String reply = repo.deleteMove("Flame Breath");
		assertEquals(reply,"{\"message\": \"Move deleted.\"}");
	}
	
	@Test
	public void testUpdateMove() {
		assertEquals("{\"message\": \"Move updated.\"}", repo.updateMove(MOCK_OBJECT, "Flame Breath"));
	}
	
}
