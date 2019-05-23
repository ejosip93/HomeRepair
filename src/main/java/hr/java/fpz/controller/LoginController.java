package hr.java.fpz.controller;

import javax.validation.Valid;

import hr.java.fpz.dao.UserDao;
import hr.java.fpz.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	UserDao userDao;

	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			ModelMap model) {

		String message = null;
		if (error != null) {
			message = "Username or Password is incorrect";
		}
		if (logout != null) {
			message = "You have been successfully logged out";
		}
		model.addAttribute("command", new User());
		model.addAttribute("message", message);
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute @Valid User user,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Error with validation");
		} else {
			userDao.addUser(user);
			model.addAttribute("message",
					"You have been successfully registered.");
		}
		model.addAttribute("command", new User());
		return "login";
	}
}
