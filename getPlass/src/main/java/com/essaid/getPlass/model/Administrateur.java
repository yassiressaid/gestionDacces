package com.essaid.getPlass.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@NamedQuery(query = "SELECT t FROM Administrateur t", name = "Administrateur.All")
@PrimaryKeyJoinColumn(name="id_user")
public class Administrateur extends User{
	
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	
	public Administrateur() {
		super();
	}

	public Administrateur(String nom, String prenom, String email, String password, Role role) {
		super(nom, prenom, email, password, role);

	}

}

