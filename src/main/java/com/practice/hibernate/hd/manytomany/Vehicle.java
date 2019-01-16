package com.practice.hibernate.hd.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "VEHICLE")
public class Vehicle {
	
	@Id
	@GeneratedValue
	@Column(name = "VEHICLE_ID")
	private int vehicleId;
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;
	
	@ManyToMany
	@JoinTable(name = "USER_VEHICLES", 
				joinColumns = @JoinColumn(name = "USER_ID"), 
				inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
	)
	private Collection<UserDetails> userList = new ArrayList<>();
	
	public Vehicle() {
	}

	public Vehicle(int vehicleId, String vehicleName) {
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Collection<UserDetails> getUserList() {
		return userList;
	}

	public void setUserList(Collection<UserDetails> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", userList=" + userList + "]";
	}

}
