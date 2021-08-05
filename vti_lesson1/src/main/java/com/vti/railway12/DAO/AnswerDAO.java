package com.vti.railway12.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.entity.Answer;

@Repository(value = "answerDAO")
@Transactional(rollbackFor = Exception.class)
public class AnswerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Answer findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Answer.class, id);
	}

	public List<Answer> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Answer";
		return session.createQuery(hql, Answer.class).getResultList();
	}
	
	public void save(Answer answer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(answer);
	}

	public void update(Answer answer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(answer);
	}

	public void delete(Answer answer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(answer);
	}
}
