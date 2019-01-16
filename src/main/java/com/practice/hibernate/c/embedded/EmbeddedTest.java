package com.practice.hibernate.c.embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.hibernate.a.entities.Address;
import com.practice.hibernate.a.utils.HibernateUtil;

public class EmbeddedTest {

	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(1);
		userDetails.setUserName("G RAVI KIRAN");
		userDetails.setUserAge(37);
	
		Address address = new Address();
		address.setStreet("Mohannagar");
		address.setCity("Hyderabad");
		address.setState("Telangana");
		address.setPincode("500035");
		
		userDetails.setAddress(address); 
		
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
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