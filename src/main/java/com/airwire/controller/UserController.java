package com.airwire.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.airwire.model.Role;
import com.airwire.model.User;
import com.airwire.service.HotelService;
import com.airwire.service.UserManagementService;
import com.airwire.service.UserService;

/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	UserManagementService userManagementService;

	/*
	 * @RequestMapping(value = "/registration", method = RequestMethod.GET)
	 * public String registration(Model model) { model.addAttribute("userForm",
	 * new User());
	 * 
	 * return "registration"; }
	 */

	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	public String createUser(Model model, Principal principal) {
		model.addAttribute("roleList", userService.findAllRole());
		User user = userService.findByUsername(principal.getName());
		Set<Role> roleSet = user.getRoles();
		List<User> userList = null;
		Iterator<Role> it = roleSet.iterator();
		if (it.hasNext()) {
			Role role = (Role) it.next();
			if (role.getName() != null
					&& (role.getName().equals("ROLE_SUPERADMIN") || role.getName().equals("ROLE_SYSTEMADMIN"))) {
				userList = userService.findAll();
			} else {
				userList = userService.getAllUserListByHotel(user.getHotelInfo());
			}
		}
		model.addAttribute("userList", userList);
		model.addAttribute("userName", principal.getName());
		model.addAttribute("orgList", hotelService.findAll());
		return "admin/createuser";
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String savehotelSetup(@ModelAttribute("command") User user, Principal principal, Model model,
			@RequestParam(required = false) Long orgId) {
		Role role = userService.getRoleById(user.getRoleId());
		Set<Role> setRole = new HashSet<Role>();
		setRole.add(role);
		user.setRoles(setRole);
		if (orgId != null && orgId > 0) {
			user.setHotelInfo(hotelService.findById(orgId));
		} else {
			User adminUser = userService.findByUsername(principal.getName());
			user.setHotelInfo(adminUser.getHotelInfo());
		}

		userService.save(user);
		return "redirect:createuser";
	}

	/*
	 * @RequestMapping(value = "/registration", method = RequestMethod.POST)
	 * public String registration(@ModelAttribute("userForm") User userForm,
	 * BindingResult bindingResult, Model model) {
	 * userValidator.validate(userForm, bindingResult);
	 * 
	 * if (bindingResult.hasErrors()) { return "registration"; }
	 * 
	 * userService.save(userForm);
	 * 
	 * securityService.autologin(userForm.getUsername(),
	 * userForm.getPasswordConfirm());
	 * 
	 * return "redirect:/welcome"; }
	 */
	@RequestMapping(value = { "/login", "/accessdenied", "/error" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login/login";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Principal principal, Model model) {

		model.addAttribute("userName", principal.getName());
		return "home/home";
	}
	
	
	@RequestMapping(value = "changepassword", method = RequestMethod.GET)
	public String changePassword(Principal principal, Model model, HttpSession session) {

		//logger.info("Inside Change password controlle"+principal.getName());

		model.addAttribute("userName", principal.getName());
		return "common/changepassword";
	}

	@RequestMapping(value = "changepassword", method = RequestMethod.POST)
	public String changePassword(Principal principal, Model model, @RequestParam String password) {
		model.addAttribute("userName", principal.getName());
		User user= userManagementService.getUserByUsername(principal.getName());
		userManagementService.updateUser(user,password);
		model.addAttribute("message","Password changed Sucessfully");
		return "common/changepassword";
	}


	@RequestMapping(value =  "reset", method = RequestMethod.GET)
	public String editform(Principal principal, Model model,@RequestParam Long id) {

		model.addAttribute("userName", principal.getName());
		User user= userManagementService.getUserById(id);
		userManagementService.updateUser(user,"1234");
		model.addAttribute("message","Password reset Sucessfully");
		return "redirect:createuser";
	}
	
	@RequestMapping(value =  "delete", method = RequestMethod.GET)
	public String delete(Principal principal, Model model,@RequestParam Long id) {

		model.addAttribute("userName", principal.getName());
		User user= userManagementService.getUserById(id);
		user.setActive(false);
		userManagementService.updateUser(user,"1234");
		model.addAttribute("message","Password reset Sucessfully");
		return "redirect:createuser";
	}
}