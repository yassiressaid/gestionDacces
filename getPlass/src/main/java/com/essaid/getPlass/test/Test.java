package com.essaid.getPlass.test;

//
import java.sql.SQLException;

import com.essaid.getPlass.repository.ApprenantRepository;

//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import com.essaid.getPlass.dao.AdministrateurDao;
//import com.essaid.getPlass.dao.AdministrateurDaoImp;
//import com.essaid.getPlass.dao.RoleDao;
//import com.essaid.getPlass.dao.RoleDaoImp;
//import com.essaid.getPlass.model.Administrateur;
//
public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		RoleDao role = new RoleDaoImp();
//		Configuration con = new Configuration().configure();
//		SessionFactory sf = con.buildSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
////		
////		Apprenant user = new Apprenant();
////		user.setNom("jhvjbhvid");
////		user.setPrenom("nbjhcdssir");
////		user.setEmail("h@gmail.com");
////		user.setPassword("123456");
////		user.setRole(role.getRoleById(1L));
////		user.setValidation(false);
////		session.save(user);
////		tx.commit();
////		TypeReservationDao type = new TypeReservationDaoImp();
////		TypeReservation typeReservation = new TypeReservation();
////		typeReservation.setType_reservation("Week-end");
////		typeReservation.setNombre_apprenant(20);
////		type.addType(typeReservation);
//		
//		AdministrateurDao dao = new AdministrateurDaoImp();
//		Administrateur administrateur = new Administrateur();
//		administrateur.setNom("Hala");
//		administrateur.setPrenom("bala");
//		administrateur.setEmail("bala@gmail.com");
//		administrateur.setPassword("1234567");
//		administrateur.setRole(role.getRoleById(3L));
//		dao.addAdministrateur(administrateur);
//		
//	}

		ApprenantRepository user = new ApprenantRepository();
		System.out.println(user.getUserByEmail("yassess.dev@gmail.com"));
	}
}
