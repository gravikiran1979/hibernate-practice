package com.practice.hibernate.s.QueryByExample;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.practice.hibernate.a.entities.UserDetails;
import com.practice.hibernate.a.utils.HibernateUtil;

public class QueryByExampleTest {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		Session session = factory.openSession();

		session.beginTransaction();
		UserDetails exampleUser = new UserDetails();
		exampleUser.setUserId(55);
		exampleUser.setUserName("User-55");
		//exampleUser.setUserAge(56);
		
		Example example = Example.create(exampleUser).enableLike().excludeProperty("userAge");
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(UserDetails.class)
							.add(example);

		@SuppressWarnings("unchecked")
		List<UserDetails> userList = (List<UserDetails>) criteria.list();		//List<Integer> usersList = (List<Integer>) criteria.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user : userList) {
			System.out.println(user);
		}

	}

}