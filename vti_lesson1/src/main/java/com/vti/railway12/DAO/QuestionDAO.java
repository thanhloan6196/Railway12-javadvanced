package com.vti.railway12.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.entity.Question;

@Repository(value = "questionDAO")
@Transactional(rollbackFor = Exception.class)
public class QuestionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Question findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Question.class, id);
	}

	public List<Question> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Question";
		return session.createQuery(hql, Question.class).getResultList();
	}
	
	public void save(Question question) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(question);
	}

	public void update(Question question) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(question);
	}

	public void delete(Question question) {
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(question);
	}
}
