package com.essaid.getPlass.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(query = "SELECT t FROM TypeReservation t", name = "TypeReservation.All")
@Table(name="type_reservation")
public class TypeReservation {
	@Id 
	@GeneratedValue
	@Column(name = "id_typeres")
	private Long id;
	private String type_reservation;
	private int nombre_apprenant;
	
	@OneToMany
	@JoinColumn(name = "id_resrvation")
	private List<Reservation> resrvations;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType_reservation() {
		return type_reservation;
	}
	public void setType_reservation(String type_reservation) {
		this.type_reservation = type_reservation;
	}
	public int getNombre_apprenant() {
		return nombre_apprenant;
	}
	public void setNombre_apprenant(int nombre_apprenant) {
		this.nombre_apprenant = nombre_apprenant;
	}
	
	public TypeReservation() {
		super();
	}
	
	public TypeReservation(String type_reservation, int nombre_apprenant) {
		super();
		this.type_reservation = type_reservation;
		this.nombre_apprenant = nombre_apprenant;
	}
	@Override
	public String toString() {
		return "TypeReservation [id=" + id + ", type_reservation=" + type_reservation + ", nombre_apprenant="
				+ nombre_apprenant + "]";
	}
	
}

