package com.nagarro.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nagarro.Exception.AdminNotExistException;
import com.nagarro.entities.Admin;

public class AdminDao {

//	private Session session;
	private SessionFactory factory;

//	public AdminDao() {
//
//		
////		this.session = Factoryprovider.SESSION;
//	}

	public AdminDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	// get user by username and password

	public Admin getUser(String email, String password) {

		Admin user = null;
		try {

			String query = "from Admin  where email=:email and password=:password";
			Session session = this.factory.openSession();
			Query q = session.createQuery(query);
			q.setParameter("email", email);
			q.setParameter("password", password);

			user = (Admin) q.uniqueResult();
			session.close();

		} catch (AdminNotExistException e) {
			System.out.println(e);

		}

		return user;

	}

}
