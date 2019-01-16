package com.practice.hibernate.ld.inheritanceJoined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "VEHICLE")
@Inheritance(strategy=InheritanceType.JOINED)
/* @DiscriminatorColumn is not required for TABLE_PER_CLASS strategy of Inheritance
 * @DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING)
 */
public class Vehicle {
	
	@Id
	@GeneratedValue
	@Column(name = "VEHICLE_ID")
	private int vehicleId;
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;
	
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
}
