package com.qa.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.CreatureService;

@RunWith(MockitoJUnitRunner.class)
public class CreatureEndPointTest {

	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";
	
	@InjectMocks
	private CreatureEndPoint endpoint;
	
	@Mock
	private CreatureService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}
	
	@Test
	public void testGetAllCreatures() {
		Mockito.when(service.getAllCreatures()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getAllCreatures());
	}
	
	@Test
	public void testGetACreature() {
		Mockito.when(service.getACreature("Mark")).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getACreature("Mark"));
	}
	
	@Test 
	public void testCreateCreature() {
		Mockito.when(service.addCreature(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.addCreature(MOCK_VALUE2));
		Mockito.verify(service).addCreature(MOCK_VALUE2);
	}
	
	@Test
	public void testDeleteCreature() {
		Mockito.when(service.deleteCreature("Mark")).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.deleteCreature("Mark"));
		Mockito.verify(service).deleteCreature("Mark");
	}
	
	@Test
	public void testUpdateCreature() {
		Mockito.when(service.updateCreature(MOCK_VALUE2, "Mark")).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.updateCreature("Mark", MOCK_VALUE2));
	}


}
