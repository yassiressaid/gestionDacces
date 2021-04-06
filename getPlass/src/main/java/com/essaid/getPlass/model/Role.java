package com.essaid.getPlass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(query = "SELECT t FROM Role t", name = "Role.All")
public class Role {
	@Id 
	@GeneratedValue
	@Column(name="id_role")
	private Long id;
	private String role;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Role() {
		super();
	}
	public Role(String role) {
		super();
		this.role = role;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}
	
}

