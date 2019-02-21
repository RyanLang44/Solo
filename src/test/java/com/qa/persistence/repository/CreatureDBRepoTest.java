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


import com.qa.persistence.domain.Creature;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class CreatureDBRepoTest {
	
	@InjectMocks
	private CreatureDBRepository repo;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	private static final String MOCK_OBJECT = "{\"charName\":\"Frank\",\"hitPoints\":10,\"magicPoints\":10,\"attack\":2,\"magic\":3,\"speed\":4}";
	
	private static final String MOCK_DATA_ARRAY ="[{\"charName\":\"Frank\",\"hitPoints\":10,\"magicPoints\":10,\"attack\":2,\"magic\":3,\"speed\":4}]";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	
	@Test
	public void testGetAllCreatures() {
		Creature test1 = new Creature("Frank", 10, 10, 2, 3, 4);
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Creature> creatures = new ArrayList<Creature>();
		creatures.add(test1);
		Mockito.when(query.getResultList()).thenReturn(creatures);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllCreatures());
	}
	
	@Test
	public void testGetACreature() {
	Mockito.when(manager.find(Creature.class, 1L)).thenReturn(util.getObjectForJSON(MOCK_OBJECT, Creature.class));
	assertEquals(MOCK_OBJECT, repo.getACreature(1L));
	}
	
	@Test
	public void testCreateCreature() {
		String reply = repo.createCreature(MOCK_OBJECT);
		assertEquals(reply,"{\"message\": \"Creature created.\"}");
	}
	
	@Test
	public void testDeleteCreature() {
		String reply = repo.deleteCreature(1L);
		assertEquals(reply,"{\"message\": \"Creature deleted.\"}");
	}
	
	@Test
	public void testUpdateCreature() {
		assertEquals("{\"message\": \"Creature updated.\"}", repo.updateCreature(MOCK_OBJECT, 1L));
	}
}
