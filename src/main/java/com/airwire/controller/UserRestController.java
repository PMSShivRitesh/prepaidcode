package com.airwire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airwire.model.User;
import com.airwire.service.UserService;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("alluser")
	public List<User> allUserList(){
		return userService.findAll();
	}

}
