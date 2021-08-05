package com.vti.railway12.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.entity.Exam;

@Repository(value = "examDAO")
@Transactional(rollbackFor = Exception.class)
public class ExamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Exam findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Exam.class, id);
	}

	public List<Exam> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Exam";
		return session.createQuery(hql, Exam.class).getResultList();
	}
	
	public void save(Exam exam) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(exam);
	}

	public void update(Exam exam) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(exam);
	}

	public void delete(Exam exam) {
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(exam);
	}
}
