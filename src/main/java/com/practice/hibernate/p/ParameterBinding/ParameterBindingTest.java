package com.practice.hibernate.p.ParameterBinding;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.practice.hibernate.a.entities.UserDetails;
import com.practice.hibernate.a.utils.HibernateUtil;

public class ParameterBindingTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		Session session = factory.openSession();

		session.beginTransaction();
		int minUserId = 3;
		String userNameLike = "User";
		@SuppressWarnings("rawtypes")
		Query queryList = session.createQuery("from UserDetails where userId > ? and userName LIKE ?");
		queryList.setInteger(0, minUserId);
		queryList.setString(1, userNameLike +"%");
		System.out.println("*List Object *");
		@SuppressWarnings("unchecked")
		List<UserDetails> usersList = (List<UserDetails>) queryList.list();
		System.out.println(usersList.size());
		Iterator<UserDetails> iter = usersList.iterator();
		while(iter.hasNext()) {
			UserDetails user = (UserDetails)iter.next();
			System.out.println(user);
		}
		
		session.getTransaction().commit();
		session.close();
	}

}