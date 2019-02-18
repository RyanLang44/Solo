package com.qa.business.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.repository.CreatureRepository;

public class ServiceTest {
	private CreatureServiceImpl creatures;

	@Before
	public void setUpRepo() {

		creatures = new CreatureServiceImpl();

	}

	@Test
	public void addCharacterTest() {
		String creature1 = "{\"charName\":\"Bobby\",\"hitPoints\":20,\"magicPoints\":10, \"attack\":5, \"magic\":15, speed\":20}";

		assertEquals("{\"message\": \"This creature is too powerful\"}", creatures.addCharacter(creature1));

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
