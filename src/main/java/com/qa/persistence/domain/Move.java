package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Move {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String moveName;
	private String desc;
	private int damage;
	private int noOfTargets;
	private int healing;
	
	
	
	public Move(String moveName, String desc, int damage, int noOfTargets, int healing) {
		this.id = id;
		this.moveName = moveName;
		this.desc = desc;
		this.damage = damage;
		this.noOfTargets = noOfTargets;
		this.healing = healing;
	}
	
	public Move() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMoveName() {
		return moveName;
	}
	public void setMoveName(String moveName) {
		this.moveName = moveName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getNoOfTargets() {
		return noOfTargets;
	}
	public void setNoOfTargets(int noOfTargets) {
		this.noOfTargets = noOfTargets;
	}
	public int getHealing() {
		return healing;
	}
	public void setHealing(int healing) {
		this.healing = healing;
	}
	
	

}
