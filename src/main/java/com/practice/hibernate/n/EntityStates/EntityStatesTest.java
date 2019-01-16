package com.practice.hibernate.n.EntityStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.hibernate.a.entities.UserDetails;
import com.practice.hibernate.a.utils.HibernateUtil;

public class EntityStatesTest {

	public static void main(String[] args) {
		
		/* In this case userDetails object is in 
		 * Transient state - not associated with any session
		 * so even if you updated it, those updates will not reflect in the database */
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName("Test User");
		userDetails.setUserAge(37);
		
		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		System.out.println(factory);
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		/* userDetails object is said to be in 
		 * Persistent State - associated with a session
		 * If userDetails object is changed after session.save(), 
		 * then the updated user object is saved in database.*/
		userDetails.setUserName("Updated User"); 			/* Case 1 */
		
		session.save(userDetails);
		
		/*If userDetails object is changed after session.save(), 
		 * then an update statement gets executed and the object is updated in database*/
		userDetails.setUserName("User in Persistent State"); 			/* Case 2 */

		/* In this case only the last update will get applied and updated in database */
		userDetails.setUserName("Re-Updated User"); 		/* Case 3 */
		
		UserDetails user = session.get(UserDetails.class, userDetails.getUserId());
		System.out.println(user);
		
		session.getTransaction().commit();
		session.close();
		
		/* Since session is closed
		 * userDetails object is said to be in 
		 * Detached State - once associated with a session, but now no more.
		 * In this case only the userDetails object is said to be in Detached object. 
		 * last update will get applied and updated in database */
		userDetails.setUserName("User in Detached State"); 		/* Case 4 */
		
		/* In this a session object has to be recreated, new transaction should begin */ 
		session = factory.openSession();
		session.beginTransaction();
		
		/* To incorporate changes made to Detached object, we need to use
		 * session.merge(object) */
		session.merge(userDetails);
		user = session.get(UserDetails.class, userDetails.getUserId());
		System.out.println(user);
		
		
		session.getTransaction().commit();
		session.close();
	}

}