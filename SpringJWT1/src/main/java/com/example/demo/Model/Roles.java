package com.example.demo.Model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;

	private String nameRoles;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public Roles() {
		super();
	}

	public Roles(String nameRoles, Set<User> users) {
		super();
		this.nameRoles = nameRoles;
		this.users = users;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getNameRoles() {
		return nameRoles;
	}

	public void setNameRoles(String nameRoles) {
		this.nameRoles = nameRoles;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
