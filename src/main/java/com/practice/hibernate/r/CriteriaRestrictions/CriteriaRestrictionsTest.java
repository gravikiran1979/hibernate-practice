package com.practice.hibernate.r.CriteriaRestrictions;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.practice.hibernate.a.entities.UserDetails;
import com.practice.hibernate.a.utils.HibernateUtil;

public class CriteriaRestrictionsTest {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		Session session = factory.openSession();
		List<UserDetails> usersList;
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserDetails.class);
	    criteria.add(Restrictions.eq("salary", 1000000));
	    usersList = (List<UserDetails>) criteria.uniqueResult();
		
	    session.getTransaction().commit();
		session.close();
		
		for(UserDetails user : usersList) {
			System.out.println(user);
		}

	}

}