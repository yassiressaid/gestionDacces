package com.essaid.getPlass.dao;

import java.sql.SQLException;
import java.util.List;

import com.essaid.getPlass.model.Reservation;

public interface ReservationDao {
	public void addReservation(Reservation reservation) throws ClassNotFoundException, SQLException;

	public void updateReservation(Reservation reservation) throws ClassNotFoundException, SQLException;

	public List<Reservation> listReservations() throws ClassNotFoundException, SQLException;

	public Reservation getReservationById(Long id) throws ClassNotFoundException, SQLException;

	public void removeReservation(Long id) throws ClassNotFoundException, SQLException;
}
