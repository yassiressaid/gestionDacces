package com.essaid.getPlass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(query = "SELECT t FROM User t", name = "User.All")
@Inheritance(strategy = InheritanceType.JOINED)
public class User{
	@Id 
	@GeneratedValue
	@Column(name = "id_user")
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	
	@OneToOne
	@JoinColumn(name="id_role")
	private Role role;
	
	@OneToOne(mappedBy = "user")
	private Administrateur admin;
	
	@OneToOne(mappedBy = "user")
	private Apprenant apprenant;
	
	
	public User() {
		super();
	}

	public User(String nom, String prenom, String email, String password, Role role) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	public Apprenant getApprenant() {
		return apprenant;
	}

	public void setApprenant(Apprenant apprenant) {
		this.apprenant = apprenant;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password
				+ ", role=" + role + "]";
	}
	
}