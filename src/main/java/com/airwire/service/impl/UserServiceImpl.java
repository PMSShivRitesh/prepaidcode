package com.airwire.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.airwire.dao.RoleRepository;
import com.airwire.dao.UserRepository;
import com.airwire.model.Role;
import com.airwire.model.User;
import com.airwire.service.UserService;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }
    
    

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public List<Role> findAllRole() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}
	
	@Override
	public Role getRoleById(Long id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id);
	}
}