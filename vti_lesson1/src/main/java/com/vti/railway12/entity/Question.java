package com.vti.railway12.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@Column(name = "QuestionID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Content")
	private String content;

	@Column(name = "CategoryID")
	private int categoryID;

	// typeID =========================================

	@Column(name = "TypeID")
	@Basic
	private int typeID;
	@Transient
	private TypeQuestion typeQuestion;

	@PostLoad
	void fillTransient() {
		if (typeID > 0) {
			this.typeQuestion = TypeQuestion.of(typeID);
		}
	}

	@PrePersist
	void fillPersistent() {
		if (typeQuestion != null) {
			this.typeID = typeQuestion.getTypeId();
		}
	}
	
	// ======================================================

	@Column(name = "CreateDate")
	@UpdateTimestamp
	private Date createDate;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
	private Set<Answer> listAnswer = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "CreatorID")
	private Account account;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

//	public Set<Answer> getListAnswer() {
//		return listAnswer;
//	}
//
//	public void setListAnswer(Set<Answer> listAnswer) {
//		this.listAnswer = listAnswer;
//	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	
	
	

}
