package com.practice.hibernate.lc.inheritanceTablePerClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.hibernate.a.utils.HibernateUtil;
import com.practice.hibernate.la.inheritance.FourWheeler;
import com.practice.hibernate.la.inheritance.TwoWheeler;

public class InheritanceTablePerClassTest {
	
	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Jeep");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Car");
		car.setSteeringWheel("Car Steering Wheel");
		
		@SuppressWarnings("rawtypes")
		Class[] classes = {Vehicle.class, TwoWheeler.class, FourWheeler.class};
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(classes);
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		//save does not include cascade object
		//persist method ties in the cascade object also
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		
		session.getTransaction().commit();
		
/*		System.out.println("Read Data from Database");
		
		@SuppressWarnings("unchecked")
		List<Vehicle> listOfVehicles = session.createQuery("from VEHICLE").getResultList();
		
		Iterator<Vehicle> iter = listOfVehicles.iterator();
		while(iter.hasNext()) {
			Vehicle vehicle1 = (Vehicle)iter.next();
			System.out.println(vehicle1);
			UserDetails userDetails1 = session.get(UserDetails.class, vehicle1.getUserDetails().getUserId());
			System.out.println(userDetails1);
		}
	*/
		session.close();
	}

}