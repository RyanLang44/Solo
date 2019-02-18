package com.qa.persistence.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RepoTest {

	private CreatureDBRepository repo;
	private Character char1;
	
	@Before
	public void setUpRepo() {
		
		repo = new CreatureDBRepository();
		
	
	}
	
	@Test
	public void testCreateCharacter() {
		
		assertEquals("Character created.", repo.createCharacter("{\"charName\":\"Bobby\",\"hitPoints\":\"20\",\"magicPoints\":10\", \"attack\":5\", \"magic\":15\", speed\":20}"));
		
	}
	@Test
	public void b() {
		
	}
	@Test
	public void c() {
		
	}
	@Test
	public void d() {
		
	}
	@Test
	public void e() {
		
	}

}
