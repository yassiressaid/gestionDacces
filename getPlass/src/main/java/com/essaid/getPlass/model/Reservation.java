package com.essaid.getPlass.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(query = "SELECT t FROM Reservation t", name = "Reservation.All")
public class Reservation {
	@Id 
	@GeneratedValue
	@Column(name = "id_resrvation")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private Apprenant apprenant;
	
	@ManyToOne
	@JoinColumn(name = "resrvations")
	private TypeReservation type;

	@Temporal(TemporalType.DATE)
	private Date date;
	
	public Reservation() {
		super();
	}
	
	public Reservation(Apprenant apprenant, TypeReservation type, Date date) {
		super();
		this.apprenant = apprenant;
		this.type = type;
		this.date = date;
	}

	public Reservation(TypeReservation type, Date date) {
		super();
		this.type = type;
		this.date = date;
	}

	public TypeReservation getType() {
		return type;
	}
	public void setType(TypeReservation type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Apprenant getApprenant() {
		return apprenant;
	}

	public void setApprenant(Apprenant apprenant) {
		this.apprenant = apprenant;
	}
	
}
