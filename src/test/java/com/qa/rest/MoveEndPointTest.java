package com.qa.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.MoveService;

@RunWith(MockitoJUnitRunner.class)
public class MoveEndPointTest {

	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";
	
	@InjectMocks
	private MoveEndPoint endpoint;
	
	@Mock
	private MoveService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}
	
	@Test
	public void testGetAllMoves() {
		Mockito.when(service.getAllMoves()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getAllMoves());
	}
	
	@Test
	public void testGetAMove() {
		Mockito.when(service.getAMove(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getAMove(1L));
	}
	
	@Test 
	public void testCreateMove() {
		Mockito.when(service.addMove(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.addMove(MOCK_VALUE2));
		Mockito.verify(service).addMove(MOCK_VALUE2);
	}
	
	@Test
	public void testDeleteMove() {
		Mockito.when(service.deleteMove(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.deleteMove(1L));
		Mockito.verify(service).deleteMove(1L);
	}
	
	@Test
	public void testUpdateMove() {
		Mockito.when(service.updateMove(MOCK_VALUE2, 1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.updateMove(1L, MOCK_VALUE2));
	}

	
}
