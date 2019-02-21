package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Creature {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	
	
	private Long id; 
	
	private String charName;
	private int hitPoints;
	private int magicPoints;
	private int attack;
	private int magic;
	private int speed;
	
	
	

	public Creature() {
		
	}

	public Creature(String charName, int hitPoints, int magicPoints, int attack, int magic, int speed)
			 {
		this.id =id;
		this.charName = charName;
		this.hitPoints = hitPoints;
		this.magicPoints = magicPoints;
		this.attack = attack;
		this.magic = magic;
		this.speed = speed;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCharName() {
		return charName;
	}


	public void setCharName(String charName) {
		this.charName = charName;
	}


	public int getHitPoints() {
		return hitPoints;
	}


	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}


	public int getMagicPoints() {
		return magicPoints;
	}


	public void setMagicPoints(int magicPoints) {
		this.magicPoints = magicPoints;
	}


	public int getAttack() {
		return attack;
	}


	public void setAttack(int attack) {
		this.attack = attack;
	}


	public int getMagic() {
		return magic;
	}


	public void setMagic(int magic) {
		this.magic = magic;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}

}

