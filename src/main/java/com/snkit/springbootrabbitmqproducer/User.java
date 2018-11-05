package com.snkit.springbootrabbitmqproducer;

import java.io.Serializable;

public class User implements Serializable {

	
	public User() {
		
	}
	
	private String name;
	
	private String email;
	
	private String desg;
	
	private String state;
	
	private String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", desg=" + desg + ", state=" + state + ", country="
				+ country + "]";
	}
	
	
}
