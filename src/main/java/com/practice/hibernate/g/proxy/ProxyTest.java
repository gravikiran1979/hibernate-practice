package com.practice.hibernate.g.proxy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.hibernate.a.entities.Address;
import com.practice.hibernate.a.utils.HibernateUtil;

public class ProxyTest {

	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(1);
		userDetails.setUserName("G RAVI KIRAN");
		userDetails.setUserAge(37);

		Address addr1 = new Address();
		addr1.setStreet("Mohannagar");
		addr1.setCity("Hyderabad");
		addr1.setState("Telangana");
		addr1.setPincode("500035");
		
		Address addr2 = new Address();
		addr2.setStreet("Innespeta");
		addr2.setCity("Rajahmundry");
		addr2.setState("AP");
		addr2.setPincode("510023");
		
		userDetails.getListOfAddress().add(addr1);
		userDetails.getListOfAddress().add(addr2);

		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		int id = 1;
		/* session.get(ClassName.class, className.id); 
		 * eagerly pulls all data from database.
		 * */
		UserDetails userDetails1 = (UserDetails) session.get(UserDetails.class, id);
		System.out.println("Read Data from Database");
		session.close();
		
		/*
		 * The below code will throw Exception since the session is already closed
		 * and the userDetails1 is a Proxy object and contains nothing in it */
		
		/* However, this Exception can be overridden by adding 
		 * @ElementCollection(fetch=FetchType.EAGER) in UserProxy.class over Address object
		 */
		
		System.out.println(userDetails1.getListOfAddress().size());
		
		//session.close();	
	}

}