package com.essaid.getPlass.dao;

import java.sql.SQLException;
import java.util.List;

import com.essaid.getPlass.model.Administrateur;

public interface AdministrateurDao {
	public void addAdministrateur(Administrateur administrateur) throws ClassNotFoundException, SQLException;

	public void updateAdministrateur(Administrateur administrateur) throws ClassNotFoundException, SQLException;

	public List<Administrateur> listAdministrateurs() throws ClassNotFoundException, SQLException;

	public Administrateur getAdministrateurById(Long id) throws ClassNotFoundException, SQLException;

	public void removeAdministrateur(Long id) throws ClassNotFoundException, SQLException;
}
