package com.practice.hibernate.r.CriteriaRestrictions;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.practice.hibernate.a.entities.UserDetails;
import com.practice.hibernate.a.utils.HibernateUtil;

public class CriteriaRestrictionsTest2 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		Session session = factory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserDetails.class);

		/* Resctrictions.or
		 * criteria.add(Restrictions.or(Restrictions.between("userAge", 39, 43), Restrictions.between("userId", 3, 8)));
		 */
/*		criteria.add(Restrictions.gt("userAge", 39))
				.add(Restrictions.lt("userAge", 43));*/
		criteria.add(Restrictions.or(Restrictions.between("userId", 1, 4), Restrictions.between("userId", 6, 8)));
		List<UserDetails> usersList = (List<UserDetails>) criteria.list();
	    
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user : usersList) {
			System.out.println(user);
		}

	}

}