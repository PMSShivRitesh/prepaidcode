package com.airwire.service;
import java.util.List;

import com.airwire.model.User;

public interface UserManagementService {

	public List<User> getAllUsers();

	//public void addUser(UserDTO userDTO);

	public User getUserByUsername(String name);

	void updateUser(User user, String password);

	User getUserById(Long id);
}