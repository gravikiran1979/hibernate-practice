package com.practice.hibernate.t.Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.hibernate.a.entities.UserDetails;
import com.practice.hibernate.a.utils.HibernateUtil;

public class CachingTest {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		Session session = factory.openSession();

		session.beginTransaction();
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		user.setUserAge(55);

		System.out.println(user);
		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = factory.openSession();
		session2.beginTransaction();
		
		UserDetails user2 = (UserDetails) session2.get(UserDetails.class, 1);
		System.out.println(user2);
		
		session2.getTransaction().commit();
		session2.close();
	}
}