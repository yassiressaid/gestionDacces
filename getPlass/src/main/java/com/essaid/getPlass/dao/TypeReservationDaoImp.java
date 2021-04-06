package com.essaid.getPlass.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.essaid.getPlass.model.TypeReservation;
import com.essaid.getPlass.util.HibernateUtil;

@Repository
public class TypeReservationDaoImp implements TypeReservationDao {

	public void addType(TypeReservation typeReservation) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(typeReservation);
			transaction.commit();
			System.out.println("Type reservation est bien crée !");
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

	public void updateType(TypeReservation typeReservation) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(typeReservation);
			transaction.commit();
			System.out.println("typeReservation est bien modifier !");
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
	public List<TypeReservation> listType() throws ClassNotFoundException, SQLException {
		Session session = null;
		List<TypeReservation> typeReservation = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Query query = session.getNamedQuery("Role.All");
			typeReservation = query.list();

			System.out.println("roles lu !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return typeReservation;
	}

	public TypeReservation getTypeById(long id) throws ClassNotFoundException, SQLException {
		TypeReservation typeReservation = null;
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();

			typeReservation = (TypeReservation) session.get(TypeReservation.class, id);
			System.out.println("Role is get !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return typeReservation;
	}

	public void removeType(long id) throws ClassNotFoundException, SQLException {
		TypeReservation typeReservation = getTypeById(id);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.delete(typeReservation);
			transaction.commit();
			System.out.println("Role supprimé !");

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
