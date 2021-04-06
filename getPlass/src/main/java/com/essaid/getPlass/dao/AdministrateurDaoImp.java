package com.essaid.getPlass.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.essaid.getPlass.util.HibernateUtil;
import com.essaid.getPlass.model.Administrateur;

@Repository
public class AdministrateurDaoImp implements AdministrateurDao{

	public void addAdministrateur(Administrateur administrateur) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			RoleDao role = new RoleDaoImp();
			administrateur.setRole(role.getRoleById(3L));
			session.saveOrUpdate(administrateur);
			transaction.commit();
			System.out.println("administrateur est bien crée !");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	public void updateAdministrateur(Administrateur administrateur) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(administrateur);
			transaction.commit();
			System.out.println("Administrateur est bien modifier !");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public List<Administrateur> listAdministrateurs() throws ClassNotFoundException, SQLException {
		Session session = null;
		List<Administrateur> administrateur = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Query query = session.getNamedQuery("Administrateur.All");
			administrateur = query.list();

			System.out.println("Administrateurs lu !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return administrateur;
	}

	public Administrateur getAdministrateurById(Long id) throws ClassNotFoundException, SQLException {
		Administrateur administrateur = null;
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			
			administrateur = (Administrateur) session.get(Administrateur.class, id);
			System.out.println("Administrateur is get !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return administrateur;
	}

	public void removeAdministrateur(Long id) throws ClassNotFoundException, SQLException {
		Administrateur administrateur = getAdministrateurById(id);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.delete(administrateur);
			transaction.commit();
			System.out.println("admin supprimé !");

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		
	}

}
