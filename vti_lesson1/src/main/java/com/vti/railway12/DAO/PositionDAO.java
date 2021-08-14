package com.vti.railway12.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.entity.Position;

@Repository(value = "positionDAO")
@Transactional(rollbackFor = Exception.class)
public class PositionDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Position findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Position.class, id);
	}

	public List<Position> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Position";
		return session.createQuery(hql, Position.class).getResultList();
	}
	
	public void save( Position position) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(position);
	}

	public void update(Position position) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(position);
	}

	public void delete(Position position) {
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(position);
	}
}
