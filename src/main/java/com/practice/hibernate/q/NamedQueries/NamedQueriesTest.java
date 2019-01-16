package com.practice.hibernate.q.NamedQueries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.practice.hibernate.a.utils.HibernateUtil;

public class NamedQueriesTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		Session session = factory.openSession();

		session.beginTransaction();
		/*Query query = session.getNamedQuery("UserDetails.byId");
		query.setInteger(0, 6);*/
		@SuppressWarnings("rawtypes")
		Query query = session.getNamedNativeQuery("UserDetails.byName");
		query.setString(0, "User-9");
		@SuppressWarnings("unchecked")
		List<UserDetails> usersList = (List<UserDetails>) query.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user : usersList) {
			System.out.println(user);
		}

	}

}