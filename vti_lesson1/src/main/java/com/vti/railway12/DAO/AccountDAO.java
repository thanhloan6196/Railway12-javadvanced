package com.vti.railway12.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.entity.Account;

@Repository(value = "accountDAO")
@Transactional(rollbackFor = Exception.class)
public class AccountDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Account findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Account.class, id);
	}

	public List<Account> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Account";
		return session.createQuery(hql, Account.class).getResultList();
	}
	
	public void save(Account account) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(account);
	}

	public void update(Account account) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(account);
	}

	public void delete(Account account) {
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(account);
	}
}
