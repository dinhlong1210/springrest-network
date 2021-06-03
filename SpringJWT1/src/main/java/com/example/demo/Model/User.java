package com.example.demo.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;

	@Size(min = 3,max=10)
	private String firstName;
	
	@Size(min=3, max =10)
	private String lastName;
	
	private String email;
	 
	@NotNull
	@Size(max=10)
	private String sdt;
	
	@NotNull
	private String password;
	
	@NotNull
	private String address;
	
	private boolean actived;
	
	@ManyToMany
	@JoinTable(	name = "user_roles", 
				joinColumns =@JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Roles> roles;

	public User() {
		super();
	}

	public User(@Size(min = 3, max = 10) String firstName, @Size(min = 3, max = 10) String lastName, String email,
			@Size(max = 10) String sdt, String address, Set<Roles> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.sdt = sdt;
		this.address = address;
		this.roles = roles;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}
}
