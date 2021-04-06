package com.essaid.getPlass.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.essaid.getPlass.util.HibernateUtil;
import com.essaid.getPlass.model.Apprenant;

@Repository
public class ApprenantDaoImp implements ApprenantDao {

	public void addApprenant(Apprenant apprenant) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			RoleDao role = new RoleDaoImp();
			apprenant.setRole(role.getRoleById(4L));
			session.saveOrUpdate(apprenant);
			transaction.commit();
			System.out.println("Apprenant est bien crée !");
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

	public void updateApprenant(Apprenant apprenant) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(apprenant);
			transaction.commit();
			System.out.println("Apprenant est bien modifier !");
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
	public List<Apprenant> listApprenants() throws ClassNotFoundException, SQLException {
		Session session = null;
		List<Apprenant> apprenants = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Query query = session.getNamedQuery("Apprenant.All");
			apprenants = query.list();

			System.out.println("Apprenants lu !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return apprenants;
	}

	public Apprenant getApprenantById(Long id) throws ClassNotFoundException, SQLException {
		Apprenant apprenant = null;
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			
			apprenant = (Apprenant) session.get(Apprenant.class, id);
			System.out.println("Apprenant is get !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return apprenant;
	}

	public void removeApprenant(Long id) throws ClassNotFoundException, SQLException {
		Apprenant apprenant = getApprenantById(id);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.delete(apprenant);
			transaction.commit();
			System.out.println("Apprenant supprimé !");

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
