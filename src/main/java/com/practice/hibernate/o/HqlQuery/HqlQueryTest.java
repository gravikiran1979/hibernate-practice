package com.practice.hibernate.o.HqlQuery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.hibernate.a.entities.UserDetails;
import com.practice.hibernate.a.utils.HibernateUtil;

@SuppressWarnings("deprecation")
public class HqlQueryTest {

	public static void main(String[] args) {
		
		/* In this case userDetails object is in 
		 * Transient state - not associated with any session
		 * so even if you updated it, those updates will not reflect in the database */
		UserDetails userDetails;
		List<UserDetails> userList = new ArrayList<>();
		for(int i=0;i<10;i++) {
			userDetails = new UserDetails();
			userDetails.setUserName("User-"+i);
			userDetails.setUserAge(37 + i);
			userList.add(userDetails);
		}
		
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		Session session = factory.openSession();

		/*session.beginTransaction();
				
		for(UserDetails user : userList) {
			session.save(user);
		}
		
		session.getTransaction().commit();
		session.close();
		
		//HQL practice
		
		session = factory.openSession();*/
		session.beginTransaction();
		
		//Instead of table name and column name, we use Entity name and field name respectively
		//Returns map of userId, userName columns
		/*Query queryMap = session.createQuery("select new map(userId, userName) from UserDetails");
		queryMap.setFirstResult(5);				//returns last file entries only
		System.out.println("*Map Object *");
		Map<Integer, String> userMap = (Map<Integer, String>)queryMap.list();
		for(Entry<Integer, String> entry : userMap.entrySet()) {
			System.out.println(entry.getKey() +" "+entry.getValue());
		}*/
		
		//Returns List of userNames
		@SuppressWarnings({ "rawtypes" })
		Query queryList = session.createQuery("select userName from UserDetails");
		System.out.println("*List Object *");
		@SuppressWarnings({ "unchecked" })
		List<String> usersList = queryList.list();
		Iterator<String> iter = usersList.iterator();
		while(iter.hasNext()) {
			String userNames = (String)iter.next();
			System.out.println(userNames);
		}
		
		session.getTransaction().commit();
		session.close();
	}

}