package com.practice.hibernate.i.mappedby;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.hibernate.a.utils.HibernateUtil;

public class MappedByTest {
	
	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName("G RAVI KIRAN");
		userDetails.setUserAge(37);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Bike");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Car");
		
		userDetails.getListOfVehicles().add(vehicle);
		userDetails.getListOfVehicles().add(vehicle2);
		
		vehicle.setUserDetails(userDetails); 
		vehicle2.setUserDetails(userDetails); 
		
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class, Vehicle.class);
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		session.save(userDetails);
		session.save(vehicle);
		session.save(vehicle2);
		
		session.getTransaction().commit();
		
		System.out.println("Read Data from Database");
		
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Vehicle> listOfVehicles = session.createQuery("from VEHICLE").list();
		
		Iterator<Vehicle> iter = listOfVehicles.iterator();
		while(iter.hasNext()) {
			Vehicle vehicle1 = (Vehicle)iter.next();
			System.out.println(vehicle1);
			/*UserDetails userDetails1 = session.get(UserDetails.class, vehicle1.getUserDetails().getUserId());
			System.out.println(userDetails1);*/
		}
	
		session.close();
	}

}