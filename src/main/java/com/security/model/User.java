package com.security.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class User extends AbstractPersistable<Long> {

	private String user_id;
	private String user_name;
	private String password;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

		}
