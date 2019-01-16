package com.practice.hibernate.g.proxy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	@GenericGenerator(name = "increment", strategy = "increment")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "increment", type = @Type(type = "long"))
	private Collection<Address> listOfAddress = new ArrayList<>();

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
	
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	public Set<Address> showListOfAddress() {
		Set<Address> addressList = new HashSet<>();
		Iterator<Address> iter = listOfAddress.iterator();
		while(iter.hasNext()) {
			addressList.add((Address)iter.next());
		}
		return addressList;
	}

	@Override
	public String toString() {
		return "UserCollections [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge +"]";
	}

}