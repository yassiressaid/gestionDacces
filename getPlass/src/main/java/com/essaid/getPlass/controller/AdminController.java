package com.essaid.getPlass.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.essaid.getPlass.dao.AdministrateurDao;
import com.essaid.getPlass.dao.ApprenantDao;
import com.essaid.getPlass.dao.RoleDao;
import com.essaid.getPlass.dao.TypeReservationDao;
import com.essaid.getPlass.model.Administrateur;
import com.essaid.getPlass.model.Apprenant;
import com.essaid.getPlass.model.Role;
import com.essaid.getPlass.model.TypeReservation;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdministrateurDao administrateurDao;
	@Autowired
	private ApprenantDao apprenantDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private TypeReservationDao typeReservationDao;

	@RequestMapping(value = "")
	public String ListApprenant(Model theModel) throws ClassNotFoundException, SQLException {
		List<Apprenant> listApprenants = apprenantDao.listApprenants();
		theModel.addAttribute("list", listApprenants);
		return "admin";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ListAdmin(Model theModel) throws ClassNotFoundException, SQLException {
		List<Administrateur> listAdministrateurs = administrateurDao.listAdministrateurs();

		theModel.addAttribute("list", listAdministrateurs);
		
		List<Role> listRoles = roleDao.listRoles();

		theModel.addAttribute("listRole", listRoles);

		List<TypeReservation> listTypes = typeReservationDao.listType();

		theModel.addAttribute("listType", listTypes);

		return "list-admins";
	}

	@RequestMapping("/AddForm")
	public String AddForm(Model theModel) throws ClassNotFoundException, SQLException {
		Administrateur administrateur = new Administrateur();
		theModel.addAttribute("admin", administrateur);
		return "admin-form";
	}
	
	@RequestMapping("/AddRole")
	public String AddType(Model theModel) throws ClassNotFoundException, SQLException {
		Role role = new Role();
		theModel.addAttribute("role", role);
		return "role-form";
	}
	
	@RequestMapping("/AddReserve")
	public String AddTypeRes(Model theModel) throws ClassNotFoundException, SQLException {
		TypeReservation typeReservation = new TypeReservation();
		theModel.addAttribute("reserve", typeReservation);
		return "type-form";
	}

	@RequestMapping(value = "/saveAdmin", method = RequestMethod.GET)
	public String saveAdmin(@ModelAttribute("admin") Administrateur administrateur)
			throws ClassNotFoundException, SQLException {
		administrateurDao.addAdministrateur(administrateur);
		return "redirect:/admin/list";
	}

	@RequestMapping(value = "/update-form", method = RequestMethod.GET)
	public String updateAdmin(@RequestParam("adminId") long theId, Model theModel)
			throws ClassNotFoundException, SQLException {
		Administrateur administrateur = administrateurDao.getAdministrateurById(theId);
		theModel.addAttribute("admin", administrateur);
		return "admin-form";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteAdmin(@RequestParam("adminId") long theId) throws ClassNotFoundException, SQLException {
		administrateurDao.removeAdministrateur(theId);
		return "redirect:/admin/list";
	}

	@RequestMapping(value = "/apprenant-delete", method = RequestMethod.GET)
	public String deleteApprenant(@RequestParam("apprenantId") long theId) throws ClassNotFoundException, SQLException {
		apprenantDao.removeApprenant(theId);
		return "redirect:/admin";
	}

	@RequestMapping(value = "/validation", method = RequestMethod.GET)
	public String valider(@RequestParam("apprenantId") long theId) throws ClassNotFoundException, SQLException {
		Apprenant apprenant = apprenantDao.getApprenantById(theId);
		apprenant.setValidation(true);
		apprenantDao.addApprenant(apprenant);
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/invalidation", method = RequestMethod.GET)
	public String invalider(@RequestParam("apprenantId") long theId) throws ClassNotFoundException, SQLException {
		Apprenant apprenant = apprenantDao.getApprenantById(theId);
		apprenant.setValidation(false);
		apprenantDao.addApprenant(apprenant);
		return "redirect:/admin";
	}

	@RequestMapping(value = "/saveRole", method = RequestMethod.GET)
	public String saveRole(@ModelAttribute("role") Role role) throws ClassNotFoundException, SQLException {
		roleDao.addRole(role);
		return "redirect:/admin/list";
	}
	
	@RequestMapping(value = "/update-Role", method = RequestMethod.GET)
	public String updateRole(@RequestParam("roleId") long theId, Model theModel) throws ClassNotFoundException, SQLException {
		Role role = roleDao.getRoleById(theId);
		theModel.addAttribute("role", role);
		return "role-form";
	}
	
	@RequestMapping(value = "/delete-Role", method = RequestMethod.GET)
	public String deleteRole(@RequestParam("roleId") long theId) throws ClassNotFoundException, SQLException {
		roleDao.removeRole(theId);
		return "redirect:/admin/list";
	}
	
	@RequestMapping(value = "/saveReserve", method = RequestMethod.GET)
	public String saveReserve(@ModelAttribute("reserve") TypeReservation typeReservation) throws ClassNotFoundException, SQLException {
		typeReservationDao.addType(typeReservation);
		return "redirect:/admin/list";
	}
	
	@RequestMapping(value = "/update-Reserve", method = RequestMethod.GET)
	public String updateReserve(@RequestParam("typeId") long theId, Model theModel) throws ClassNotFoundException, SQLException {
		TypeReservation typeReservation = typeReservationDao.getTypeById(theId);
		theModel.addAttribute("reserve", typeReservation);
		return "role-form";
	}
	
	@RequestMapping(value = "/delete-Reserve", method = RequestMethod.GET)
	public String deleteReserve(@RequestParam("typeId") long theId) throws ClassNotFoundException, SQLException {
		typeReservationDao.removeType(theId);
		return "redirect:/admin/list";
	}

}
