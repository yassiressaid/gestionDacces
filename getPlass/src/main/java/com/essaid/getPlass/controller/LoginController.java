package com.essaid.getPlass.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.essaid.getPlass.model.Apprenant;
import com.essaid.getPlass.model.User;
import com.essaid.getPlass.repository.ApprenantRepository;
import com.essaid.getPlass.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private UserRepository user;
	@Autowired
	private ApprenantRepository apprenant;
	Session session;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpSession session, Model model) {
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		User users = user.getUserByEmail(email);
		Apprenant apprenants = apprenant.getUserByEmail(email);
		if (users != null && users.getPassword().equals(password)) {
			
			if (users.getRole().getRole().equals("Admin")) {
				return "redirect:/admin";
			} else if (apprenants != null && apprenants.getRole().getRole().equals("Apprenant") && apprenants.isValidation() == true) {
				return "redirect:/apprenant";
			}
		} else {
			User user = new User();
			model.addAttribute("user", user);
			model.addAttribute("msg", "Email or Password incorrect");
			return "home";
		}
		System.out.println("Not working");
		return "home";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
}
