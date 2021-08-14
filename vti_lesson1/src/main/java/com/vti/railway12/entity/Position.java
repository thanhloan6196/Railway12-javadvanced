package com.vti.railway12.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class Position {

	@Id
	@Column(name = "PositionID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "PositionName")
	@Enumerated(EnumType.STRING)
	PositionName positionName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "position")
	private Set<Account> listAccount = new HashSet<>();


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PositionName getPositionName() {
		return positionName;
	}

	public void setPositionName(PositionName positionName) {
		this.positionName = positionName;
	}
	
	
}
