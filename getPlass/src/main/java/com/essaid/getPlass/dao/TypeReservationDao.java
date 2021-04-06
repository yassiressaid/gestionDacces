package com.essaid.getPlass.dao;

import java.sql.SQLException;
import java.util.List;

import com.essaid.getPlass.model.TypeReservation;



public interface TypeReservationDao {
	public void addType(TypeReservation typeReservation) throws ClassNotFoundException, SQLException;
	public void updateType(TypeReservation typeReservation) throws ClassNotFoundException, SQLException;
	public List<TypeReservation> listType() throws ClassNotFoundException, SQLException;
	public TypeReservation getTypeById(long id) throws ClassNotFoundException, SQLException;
	public void removeType(long id) throws ClassNotFoundException, SQLException;
}
