package com.vti.railway12.entity;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@Column(name = "accountID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "Username")
	private String userName;

	@Column(name = "FullName")
	private String fullName;
	
	@ManyToOne
	@JoinColumn(name = "DepartmentID")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "PositionID")
	private Position position;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
	private Set<Exam> listExam = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
	private Set<Question> listQuestion = new HashSet<>();
	
	@Column(name ="createDate")
	@CreationTimestamp
	private Date createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	


}
