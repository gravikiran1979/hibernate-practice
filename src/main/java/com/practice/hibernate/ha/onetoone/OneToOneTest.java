package com.practice.hibernate.ha.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.hibernate.a.utils.HibernateUtil;

public class OneToOneTest {
	
	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(1);
		userDetails.setUserName("G RAVI KIRAN");
		userDetails.setUserAge(37);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("CAR");

		userDetails.setVehicle(vehicle);
		
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class, Vehicle.class);
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		int id = (int) session.save(userDetails);
		session.save(vehicle);
		
		session.getTransaction().commit();
		
		System.out.println("Read Data from Database");
		
		UserDetails userDetails1 = (UserDetails) session.get(UserDetails.class, id);
		
		System.out.println(userDetails1);
		session.close();
	}

}