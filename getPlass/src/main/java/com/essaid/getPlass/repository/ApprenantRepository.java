package com.essaid.getPlass.repository;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.essaid.getPlass.model.Apprenant;
import com.essaid.getPlass.util.HibernateUtil;
@Repository
public class ApprenantRepository {
	public Apprenant getUserByEmail(String email) {
		Session session;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Apprenant as a where a.email=: email");
		query.setParameter("email", email);
		try {
			Apprenant apprenant = (Apprenant) query.getSingleResult();
			return apprenant;
		} catch (Exception e) {
			return null;
		}
	}
}
