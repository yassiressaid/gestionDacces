package com.essaid.getPlass.repository;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.essaid.getPlass.model.User;
import com.essaid.getPlass.util.HibernateUtil;
@Repository
public class UserRepository {
	public User getUserByEmail(String email) {
		Session session;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User as u where u.email=: email");
		query.setParameter("email", email);
		try {
			User user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}
}
