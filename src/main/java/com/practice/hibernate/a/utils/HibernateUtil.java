package com.practice.hibernate.a.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private volatile static SessionFactory factory;

	private HibernateUtil() {
		
	}

	public static SessionFactory getSessionFactoryInstance() {
		
		Configuration config = new Configuration();
		
		factory = config.configure("hibernate.cfg2.xml").buildSessionFactory();
		
		return factory;
		
	}

	@SuppressWarnings("rawtypes")
	public static SessionFactory getSessionFactoryInstance(Class className) {
		
		Configuration config = new Configuration();
		
		config.addAnnotatedClass(className);
		
		factory = config.configure().buildSessionFactory();
		
		return factory;
		
	}
	
	@SuppressWarnings("rawtypes")
	public static SessionFactory getSessionFactoryInstance(Class[] classes) {
		
		Configuration config = new Configuration();
		
		for(Class className : classes) {
			config.addAnnotatedClass(className);
		}
		
		factory = config.configure().buildSessionFactory();
		
		return factory;
		
	}
	
	@SuppressWarnings("rawtypes")
	public static SessionFactory getSessionFactoryInstance(Class class1, Class class2) {
		
		Configuration config = new Configuration();
		
		config.addAnnotatedClass(class1);
		config.addAnnotatedClass(class2);
		
		factory = config.configure().buildSessionFactory();
		
		return factory;
		
	}
	
}