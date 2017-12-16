package com.airwire.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airwire.model.Role;
import com.airwire.model.User;
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

    /*@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }*/
    
    @RequestMapping(value = "/createuser", method = RequestMethod.GET)
    public String createUser(Model model, Principal principal) {
        model.addAttribute("roleList", userService.findAllRole());
        User user = userService.findByUsername(principal.getName());
        List<User> userList = userService.getAllUserListByHotel(user.getHotlInfo());
        model.addAttribute("userList",userList);
        model.addAttribute("userName",principal.getName());
        return "admin/createuser";
    }
    
    
 
    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public String savehotelSetup(@ModelAttribute("command") User user, Principal principal, Model model) {
    	Role role = userService.getRoleById(user.getRoleId());
    	Set<Role> setRole = new HashSet<Role>();
    	setRole.add(role);
    	user.setRoles(setRole);
    	User adminUser = userService.findByUsername(principal.getName());
    	user.setHotlInfo(adminUser.getHotlInfo());
	 	userService.save(user);
        return "redirect:createuser";
    }

   /* @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }
*/
    @RequestMapping(value = {"/login","/accessdenied","/error"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login/login";
    }
    
    
   

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Principal principal,Model model) {
    	
    	model.addAttribute("userName",principal.getName());
        return "home/home";
    }
}