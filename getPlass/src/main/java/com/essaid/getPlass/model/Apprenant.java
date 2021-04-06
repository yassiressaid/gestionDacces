package com.essaid.getPlass.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@NamedQuery(query = "SELECT t FROM Apprenant t", name = "Apprenant.All")
@PrimaryKeyJoinColumn(name="id_user")
public class Apprenant extends User {

	private boolean validation;
	
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@OneToMany(mappedBy = "apprenant")
	private List<Reservation> resrvations;

	public Apprenant() {

	}

	public Apprenant(String nom, String prenom, String email, String password, Role role, boolean validation) {
		super(nom, prenom, email, password, role);
		this.validation = validation;
	}

	public boolean isValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Reservation> getResrvations() {
		return resrvations;
	}

	public void setResrvations(List<Reservation> resrvations) {
		this.resrvations = resrvations;
	}

}

