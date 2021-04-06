package com.essaid.getPlass.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.essaid.getPlass.util.HibernateUtil;
import com.essaid.getPlass.model.User;

@Repository
public class UserDaoImp implements UserDao{

	public void addUser(User user) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
			System.out.println("User est bien crée !");
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

	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			System.out.println("User est bien modifier !");
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
	public List<User> listUsers() throws ClassNotFoundException, SQLException {
		Session session = null;
		List<User> user = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Query query = session.getNamedQuery("User.All");
			user = query.list();

			System.out.println("Users lu !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return user;
	}

	public User getUserById(Long id) throws ClassNotFoundException, SQLException {
		User user = null;
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			
			user = (User) session.get(User.class, id);
			System.out.println("User is get !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return user;
	}

	public void removeUser(Long id) throws ClassNotFoundException, SQLException {
		User user = getUserById(id);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
			System.out.println("User supprimé !");

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
