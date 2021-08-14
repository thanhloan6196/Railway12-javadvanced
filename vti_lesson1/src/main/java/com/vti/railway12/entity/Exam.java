package com.vti.railway12.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam {

	@Id
	@Column(name = "ExamID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Code")
	private String code;

	@Column(name = "Title")
	private String title;

	@Column(name = "CategoryID")
	private int CategoryID;
	
	@Column(name = "Duration")
	private int duration;
	
	@Column(name = "CreateDate")
	private Date createDate;
	
	
	@ManyToOne()
	@JoinColumn(name = "CreatorID")
	private Account account;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getCategoryID() {
		return CategoryID;
	}


	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	
	
	
}

