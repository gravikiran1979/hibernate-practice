package com.practice.hibernate.s.Projections;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.practice.hibernate.a.entities.UserDetails;
import com.practice.hibernate.a.utils.HibernateUtil;

public class ProjectionsTest {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		Session session = factory.openSession();

		session.beginTransaction();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(UserDetails.class)
				.setProjection(Projections.property("userId"))
				//.setProjection(Projections.count("userId")) 
				.addOrder(Order.desc("userId"));

		@SuppressWarnings("unchecked")
		//List<UserDetails> userList = (List<UserDetails>) criteria.list();
		List<Integer> usersList = (List<Integer>) criteria.list();
		session.getTransaction().commit();
		session.close();
		
		for(Integer user : usersList) {
			System.out.println(user);
		}

	}

}