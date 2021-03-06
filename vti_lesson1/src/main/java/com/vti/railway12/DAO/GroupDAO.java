package com.vti.railway12.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.entity.Group;

@Repository(value = "groupDAO")
@Transactional(rollbackFor = Exception.class)
public class GroupDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Group findById(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Group.class, id);
	}

	public List<Group> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Group";
		return session.createQuery(hql, Group.class).getResultList();
	}
	
	public void save(Group group) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(group);
	}

	public void update(Group group) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(group);
	}

	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(id);
	}
}
