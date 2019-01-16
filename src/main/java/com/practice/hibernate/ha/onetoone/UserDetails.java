package com.practice.hibernate.ha.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@OneToOne
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle vehicle;

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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", vehicle="
				+ vehicle + "]";
	}

}