package com.example.demo.Security.Payload.Request;

import java.io.Serializable;

public class SignupAdminRequest implements Serializable{
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String sdt;
	private String address;
	public SignupAdminRequest() {
		super();
	}
	public SignupAdminRequest(Long id,String email, String firstName, String lastName, String password, String sdt,String address) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.sdt = sdt;
		this.address=address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
