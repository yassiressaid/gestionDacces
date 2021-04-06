package com.essaid.getPlass.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.essaid.getPlass.util.HibernateUtil;
import com.essaid.getPlass.model.Role;
@Repository
public class RoleDaoImp implements RoleDao{

	public void addRole(Role role) {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(role);
			transaction.commit();
			System.out.println("Role est bien crée !");
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

	public void updateRole(Role role) {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(role);
			transaction.commit();
			System.out.println("Role est bien modifier !");
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
	public List<Role> listRoles() {
		Session session = null;
		List<Role> role = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Query query = session.getNamedQuery("Role.All");
			role = query.list();

			System.out.println("roles lu !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return role;
	}

	public Role getRoleById(Long id) {
		Role role = null;
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			
			role = (Role) session.get(Role.class, id);
			System.out.println("Role is get !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return role;
	}

	public void removeRole(Long id) {
		Role role = getRoleById(id);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.delete(role);
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
