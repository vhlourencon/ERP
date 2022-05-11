package br.com.erp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectFactory {
	private static SessionFactory sessionFactory = null;

	static {
		try {
			sessionFactory = getSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			SessionFactory sessionFactory = new Configuration().configure("br/com/erp/Hibernate.cfg.xml")
					.buildSessionFactory();
			sessionFactory.openSession();
			return sessionFactory;
		}
		return sessionFactory;
	}

	public static Session getSession() {
		return getSessionFactory().getCurrentSession();

	}

}