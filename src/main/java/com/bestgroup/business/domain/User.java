package com.bestgroup.business.domain;

import java.util.List;

import javax.persistence.Table;

import com.bestgroup.core.DomainEntity;

@Table(name = "users")
public class User extends DomainEntity {

	protected String firstName;
	protected String lastName;
	protected List<Role> roles;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
