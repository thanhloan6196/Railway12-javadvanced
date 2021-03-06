package com.vti.railway12.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.entity.HocSinh;

@Repository(value = "hocsinhDAO")
@Transactional(rollbackFor = Exception.class)
public class HocSinhDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public HocSinh findById(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(HocSinh.class, id);
	}

	public List<HocSinh> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM HocSinh";
		return session.createQuery(hql, HocSinh.class).getResultList();
	}
	
	public void save(final HocSinh hocSinh) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(hocSinh);
	}

	public void update(final HocSinh hocSinh) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(hocSinh);
	}

	public void delete(final HocSinh hocSinh) {
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(hocSinh);
	}
}