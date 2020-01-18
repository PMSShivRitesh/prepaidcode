package com.airwire.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.airwire.dao.RoleRepository;
import com.airwire.dao.UserRepository;
import com.airwire.model.User;
import com.airwire.service.UserManagementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserManagementServiceImpl implements UserManagementService {

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	

	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	@Transactional(readOnly = false)
	public List<User> getAllUsers(){

		return userRepository.findAll();
	}

//	@Override
//	public void addUser(UserDTO userDTO) {
//
//		Role role = roleRepository.getRoleById(userDTO.getRoleId());
//		Branch branch = branchRepository.getBranchObject(userDTO.getBranchId());
//		User user= new User();
//		BeanUtils.copyProperties(userDTO, user);
//		user.setBranch(branch);
//		Set<Role> roles = new HashSet<Role>();
//		roles.add(role);
//		user.setRoles(roles);
//		user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
//		userRepository.save(user);
//	}
	
	
	@Override
	public void updateUser(User user, String password) {
		
		user.setPassword(bCryptPasswordEncoder.encode(password));
		userRepository.save(user);
	}

	@Override
	public User getUserByUsername(String name) {
		User user = userRepository.findByUsername(name);
//		if(user.getHotelInfo()!=null){
//			user.setGroupName(user.getBranch().getGroups().getName());
//		}
		return user;
	}
	
	@Override
	public User getUserById(Long id) {
		return userRepository.getUserById(id);
	}
	
}