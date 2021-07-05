package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

public class AccountRepository {
	private HibernateUtils hibernateUltis;

	public AccountRepository() {
		hibernateUltis = HibernateUtils.getInstance();
	}

	public List<Account> getAllAccount() {
		Session session = null;

		try {
			// get session
			session = hibernateUltis.openSession();

			// create hql query
			Query<Account> query = session.createQuery("from Account order by id");

			return query.list();

		} finally {

			if (session != null) {
				session.close();
			}

		}
	}

	
}
