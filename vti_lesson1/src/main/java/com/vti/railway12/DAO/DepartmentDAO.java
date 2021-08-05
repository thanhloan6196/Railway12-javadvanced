package com.vti.railway12.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.entity.Department;

@Repository(value = "departmentDAO")
@Transactional(rollbackFor = Exception.class)
public class DepartmentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Department findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Department.class, id);
	}

	public List<Department> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Department";
		return session.createQuery(hql, Department.class).getResultList();
	}
	
	public void save(Department department) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(department);
	}

	public void update(Department department) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(department);
	}
	
	public void delete(Department department) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(department);
	}

}
