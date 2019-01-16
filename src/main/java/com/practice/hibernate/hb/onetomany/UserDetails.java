package com.practice.hibernate.hb.onetomany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ")
	@Column(name = "USER_ID", unique = true, nullable = false)
	private int userId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "USER_AGE")
	private int userAge;
	
	@OneToMany
	@JoinTable(name="USER_VEHICLES",
				joinColumns=@JoinColumn(name="USER_ID"),
				inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
	)

	private Collection<Vehicle> listOfVehicles = new ArrayList<>();

	public UserDetails() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName; 
	}

	public int getUserAge() {
		return this.userAge;
	}
	
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public Collection<Vehicle> getListOfVehicles() {
		return listOfVehicles;
	}

	public void setListOfVehicles(Collection<Vehicle> listOfVehicles) {
		this.listOfVehicles = listOfVehicles;
	}

	public Set<Vehicle> showListOfVehicles() {
		Set<Vehicle> VehiclesList = new HashSet<>();
		Iterator<Vehicle> iter = listOfVehicles.iterator();
		while(iter.hasNext()) {
			VehiclesList.add((Vehicle)iter.next());
		}
		return VehiclesList;
	}

	@Override
	public String toString() {
		return "UserCollections [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge +"]";
	}
}