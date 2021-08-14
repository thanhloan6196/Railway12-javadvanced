package com.vti.fake.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "position")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Enumerated(EnumType.STRING)
	private PositionName positionName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "position", cascade = {CascadeType.REMOVE})
//	@JsonIgnore
	private Set<Account> listAccounts = new HashSet<Account>();

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

//	public Set<Account> getListAccounts() {
//		return listAccounts;
//	}
//
//	public void setListAccounts(Set<Account> listAccounts) {
//		this.listAccounts = listAccounts;
//	}
//	
	
}
