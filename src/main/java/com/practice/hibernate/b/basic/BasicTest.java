package com.practice.hibernate.b.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.hibernate.a.entities.UserDetails;
import com.practice.hibernate.a.utils.HibernateUtil;

public class BasicTest {

	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(1);
		userDetails.setUserName("G RAVI KIRAN");
		userDetails.setUserAge(37);

		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		System.out.println(factory);
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		
		System.out.println("Read Data from Database");
		int id = 1;
		
		UserDetails userDetails1 = (UserDetails) session.get(UserDetails.class, id);
		
		System.out.println(userDetails1);
		
		session.close();
	}

}