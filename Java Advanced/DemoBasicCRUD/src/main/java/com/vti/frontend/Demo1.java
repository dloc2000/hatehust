package com.vti.frontend;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;


import com.vti.entity.TestingCategory;

public class Demo1 {
	public static void main(String[] args) {
		Session session = null;
		try {
			// Tạo session
			session = buildSessionFactory().openSession();
			session.beginTransaction();

			// Tạo mới 1 bản ghi
			TestingCategory testingCategory = new TestingCategory();
			testingCategory.setName("Hibernate2");
			
			session.save(testingCategory);
			System.out.println("Tạo thành công");
			
			// Select dữ liệu cơ bản
			Query<TestingCategory> query = session.createQuery("FROM TestingCategory");
			List<TestingCategory> listTestingCategories = query.list();
			for (TestingCategory abc : listTestingCategories) {
				System.out.println("ID:" + abc.getId() + "/n Name: " + abc.getName());
			}
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		;

	}

	private static SessionFactory buildSessionFactory() {
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(TestingCategory.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		
		return configuration.buildSessionFactory(serviceRegistry);

	}
}
