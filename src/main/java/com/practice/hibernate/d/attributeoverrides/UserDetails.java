package com.practice.hibernate.d.attributeoverrides;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.practice.hibernate.a.entities.Address;

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

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street", column=@Column(name = "HOME_STREET")),
		@AttributeOverride(name = "city", column=@Column(name = "HOME_CITY")),
		@AttributeOverride(name = "state", column=@Column(name = "HOME_STATE")),
		@AttributeOverride(name = "pincode", column=@Column(name = "HOME_PINCODE"))
	})
	private Address homeAddress;

	@Embedded
	private Address officeAddress;

	public UserDetails() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "UserEmbed2 [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", homeAddress="
				+ homeAddress + ", officeAddress=" + officeAddress + "]";
	}

}