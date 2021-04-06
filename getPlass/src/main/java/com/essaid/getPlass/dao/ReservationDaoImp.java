package com.essaid.getPlass.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.essaid.getPlass.util.HibernateUtil;
import com.essaid.getPlass.model.Reservation;

@Repository
public class ReservationDaoImp implements ReservationDao {

	public void addReservation(Reservation reservation) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(reservation);
			transaction.commit();
			System.out.println("Reservation est bien crée !");
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

	public void updateReservation(Reservation reservation) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(reservation);
			transaction.commit();
			System.out.println("Reservation est bien modifier !");
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
	public List<Reservation> listReservations() throws ClassNotFoundException, SQLException {
		Session session = null;
		List<Reservation> reservation = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Query query = session.getNamedQuery("Role.All");
			reservation = query.list();

			System.out.println("Reservations lu !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return reservation;
	}

	public Reservation getReservationById(Long id) throws ClassNotFoundException, SQLException {
		Reservation reservation = null;
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();

			reservation = (Reservation) session.get(Reservation.class, id);
			System.out.println("Reservation is get !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return reservation;
	}

	public void removeReservation(Long id) throws ClassNotFoundException, SQLException {
		Reservation reservation = getReservationById(id);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.delete(reservation);
			transaction.commit();
			System.out.println("Reservation supprimé !");

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
