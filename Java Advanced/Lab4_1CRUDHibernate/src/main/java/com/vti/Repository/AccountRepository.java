package com.vti.Repository;

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

	@SuppressWarnings("unchecked")

	// Giới hạn số lượng cột cần lấy sử dụng mệnh đề SELECT.
	public String getFullName(short id) {
		Session session = null;
		try {
			session = hibernateUltis.openSession();
			// create hql query , hàm trả về đối tượng kiểu String . ko phải là cả account
			String hql = "SELECT a.fullName FROM Account a WHERE id = :id";

			Query<String> query = session.createQuery(hql, String.class);
			query.setParameter("id", id);
			// lấy kết quả
			String fullname = query.uniqueResult();
			return fullname;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// Lấy ra tất cả các Account tạo ra trong tháng đó.
	public List<Account> getByCurrentMonth() {
		Session session = null;
		try {
			session = hibernateUltis.openSession();

			String hql = "FROM Account a WHERE month(a.createDate) = month(sysdate())";

			Query<Account> query = session.createQuery(hql, Account.class);

			List<Account> accounts = query.list();

			return accounts;

		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	// Như trên và sắp xếp ASC or DESC
	public List<Account> getByCurrentMonthOrderBy() {

		Session session = null;

		try {

			session = hibernateUltis.openSession();

			String hql = "FROM Account a WHERE month(a.createDate) = month(sysdate())" + "ORDER BY a.createDate DESC";
			Query<Account> query = session.createQuery(hql, Account.class);

			List<Account> accounts = query.list();
			return accounts;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// Đếm số Account được tạo trong mỗi tháng của năm hiện tại
	public List<Object[]> getCountAccByMonthInYearCurrent() {
		Session session = null;

		try {
			session = hibernateUltis.openSession();

			String hql = "SELECT month(createDate) AS month , COUNT(createDate) AS SL"
					+ "FROM Account WHERE year(createDate) = year(sysdate()) GROUP BY month(createDate) ";
			// Trả về 1 mảng kiểu đối tượng
			Query<Object[]> query = session.createQuery(hql);

			List<Object[]> results = query.list();
			return results;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// Đếm số Account được tạo trong mỗi tháng của năm hiện tại với điều kiện
	// tháng có ít nhất 2 Account được tạo
	public List<Object[]> getCountAccByMonthInYearCurrent2() {

		Session session = null;

		try {
			session = hibernateUltis.openSession();

			String hql = "SELECT month(createDate) AS month,"
					+ "COUNT(createDate) AS SL FROM Account WHERE year(createDate) = year(sysdate())"
					+ "GROUP BY month(createDate) HAVING COUNT(createDate) >2";
			Query<Object[]> query = session.createQuery(hql);
			List<Object[]> results = query.list();

			return results;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// Update
	public void updateEUAByID(String email, String Username, short id) {
		Session session = null;

		try {
			session = hibernateUltis.openSession();

			String hql = "UPDATE Account SET email = :email, username = :username WHERE id = :id";

			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("username", Username);
			query.setParameter("id", id);
			int affectedRows = query.executeUpdate();

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// Delete
	public void deleteAccount(String email) {
		Session session = null;
		
		try {
			session = hibernateUltis.openSession();
			session.beginTransaction();

			String hql = "DELETE FROM Account WHERE email = :email";

			Query query = session.createQuery(hql);
			query.setParameter("email", email);
	
			int affectedRows = query.executeUpdate();

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	// Phân trang bằng hibernate
	public List<Account> getAccountByPaging(){
Session session = null;
		
		try {
			session = hibernateUltis.openSession();
			
			String hql = "FROM Account ORDER BY id";

			Query<Account> query = session.createQuery(hql);
			query.setFirstResult(5);
			query.setMaxResults(3);

			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
