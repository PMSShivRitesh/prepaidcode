package com.airwire.service;

import java.util.List;

import com.airwire.model.Role;
import com.airwire.model.User;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface UserService {

	void save(User user);
	User findByUsername(String username);
	List<User> findAll();
	List<Role> findAllRole();
	Role getRoleById(Long id);
}
