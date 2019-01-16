package com.practice.hibernate.m.Crud;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.hibernate.a.entities.UserDetails;
import com.practice.hibernate.a.utils.HibernateUtil;

public class CrudTest {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		System.out.println(factory);
		Session session = factory.openSession();
		
		session.beginTransaction();
		System.out.println("Creating data & Inserting into Database"+"\n");
		for(int i=0;i<10;i++) {
			UserDetails userDetails = new UserDetails();
			userDetails.setUserName("User "+i);
			userDetails.setUserAge(30 + i);
			session.save(userDetails);
		}
		
		//session.getTransaction().commit();
		
		System.out.println("Reading Data from Database"+"\n");
		int id = 5;
		
		UserDetails userDetails1 = session.get(UserDetails.class, id);
		
		System.out.println(userDetails1+"\n");
		//session.beginTransaction();
		System.out.println("Deletin Data from Database"+"\n");
		System.out.println(userDetails1+"\n");
		session.delete(userDetails1);
		System.out.println("Check if data is deleted"+"\n");

		System.out.println("Updating Data in Database"+"\n");
		UserDetails user = session.get(UserDetails.class, 6);
		user.setUserAge(87);
		user.setUserName("Mental");
		session.saveOrUpdate(user);
		
		// Create CriteriaBuilder
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(UserDetails.class);

	    @SuppressWarnings("unchecked")
		List<UserDetails> usersList = criteria.list();
		for(UserDetails myuser : usersList) {
			System.out.println(myuser);
		}

		session.getTransaction().commit();
		session.close();
	}
}