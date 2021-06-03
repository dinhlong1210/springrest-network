package com.example.demo.Security.Payload.Request;

public class SignupRequest {
	private String firstName;
	private String lastName;
	private String password;
	private String confirmPassword;
	private String email;
	private String address;
	private String sdt;
	
	public SignupRequest() {
		super();
	}
	
	public SignupRequest(String firstName, String lastName, String password, String confirmPassword, String email,
			String address, String sdt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.address = address;
		this.sdt = sdt;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
}
