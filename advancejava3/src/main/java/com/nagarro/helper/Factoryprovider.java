package com.nagarro.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factoryprovider {
//	private Factoryprovider() {
//
//	}
//
//	public static final SessionFactory GET_FACTORY = new Configuration().configure("hibernate.cfg.xml")
//			.addAnnotatedClass(Admin.class).addAnnotatedClass(ProductDetails.class).buildSessionFactory();
//
//	public static final Session SESSION = GET_FACTORY.openSession();
	private static SessionFactory factory;

	public static SessionFactory getFactory() {
		try {
			if (factory == null) {
				factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return factory;
	}

}
