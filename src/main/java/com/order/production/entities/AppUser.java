package com.order.production.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

@Entity
public class AppUser implements Serializable{
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@javax.persistence.Id
	private Long Id;
	private String userName;
	private String password;
	@OneToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> Roles;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<AppRole> getRoles() {
		return Roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		Roles = roles;
	}

}
