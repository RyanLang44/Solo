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
	public void testGetAllCharacters() {
		Mockito.when(service.getAllCharacters()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getAllCharacters());
	}
	
	@Test
	public void testGetACharacter() {
		Mockito.when(service.getACharacter(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getACharacter(1L));
	}
	
	@Test 
	public void testCreateCharacter() {
		Mockito.when(service.addCharacter(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.addCharacter(MOCK_VALUE2));
		Mockito.verify(service).addCharacter(MOCK_VALUE2);
	}
	
	@Test
	public void testDeleteCharacter() {
		Mockito.when(service.deleteCharacter(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.deleteCharacter(1L));
		Mockito.verify(service).deleteCharacter(1L);
	}
	
	@Test
	public void testUpdateCharacter() {
		Mockito.when(service.updateCharacter(MOCK_VALUE2, 1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.updateCharacter(1L, MOCK_VALUE2));
	}


}
