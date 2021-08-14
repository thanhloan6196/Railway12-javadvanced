package com.vti.fake.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Email(message = "Email không hợp lệ")
	private String email;
	
	@NotEmpty(message = "Thiếu user name")
	private String userName;
	
	@NotEmpty(message = "Thiếu Full Name")
	private String fullName;
	

	@UpdateTimestamp
	private Date updateAt;
	
	@CreationTimestamp
	private Date createDate;
	
	@ManyToOne
//	@JoinColumn(name = "Department_ID")
	private Department department;
	
	@ManyToOne
//	@JoinColumn(name = "Position_ID")
	private Position position;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

//	public int getDepartmentId() {
//		return departmentId;
//	}
//
//	public void setDepartmentId(int departmentId) {
//		this.departmentId = departmentId;
//	}
//
//	public int getPositionId() {
//		return positionId;
//	}
//
//	public void setPositionId(int positionId) {
//		this.positionId = positionId;
//	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	
	
}
