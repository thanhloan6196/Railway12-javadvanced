package com.vti.railway12.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.vti.railway12.audit.Auditable;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "account")
public class Account extends Auditable<String>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Email( message = "Email không hợp lệ")
	private String email;

	@NotEmpty(message = " Thiếu username")
	private String userName;

	@NotEmpty(message = " Thiếu fullname")
	private String fullName;

	@ManyToOne
	private Department department;

	@ManyToOne
	private Position position;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + "  	"  + this.fullName;
	}
	
	
	
}
