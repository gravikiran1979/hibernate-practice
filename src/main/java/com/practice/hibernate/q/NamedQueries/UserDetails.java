package com.practice.hibernate.q.NamedQueries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId = ?") 
//query contains hql
@NamedNativeQuery(name = "UserDetails.byName", query = "select * from USER_DETAILS where USER_NAME = ?", resultClass=UserDetails.class)
//query contains sql
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

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + "]";
	}

}