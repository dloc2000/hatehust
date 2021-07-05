package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Department;

public class DepartmentRepository {
	private SessionFactory sessionFactory;

	public DepartmentRepository() {
		sessionFactory = buildSessionFactory();
	}

	private SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Department.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

	@SuppressWarnings("deprecation")
	public List<Department> getAllDepartments() {

		Session session = null;

		try {
			session = sessionFactory.openSession();
			Query<Department> query = session.createQuery("FROM Department");

			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
	
	public Department getDepartmentByID(short id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Department department = session.get(Department.class, id);
			return department;
		} finally {
			if (session != null) {
				session.close();
				}
		}
	}
	
	public Department getDepartmentByName(String name) {
		
		
		Session session = null;
		try {
			// gey session
			session = sessionFactory.openSession();
			
			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE name = :name");
			
			// set parameter
			query.setParameter("name", name);
			
			// get result
			Department department = query.uniqueResult(); // tra ra 1 ket qua
			return department;
		} finally {
			if (session != null) {
				session.close();
				}
		}
	}

	public void createDepartment(Department department) {
		Session session = null;
		
		try {
			//get session
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			// create
			session.save(department);
			
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
				}
		}
	}
	
	public boolean isDepartmentExistsByID(short  id) {
		// get department
		Department department = getDepartmentByID(id);
		
		//return result
		if(department == null ) {
			return false;
		}
		return true;
	
	}
	
	public boolean isDepartmentExistByName(String name) {
		Department department = getDepartmentByName(name);
		
		if(department == null) {
			return false;
		}
		return true;
	}
}
	


	

	
