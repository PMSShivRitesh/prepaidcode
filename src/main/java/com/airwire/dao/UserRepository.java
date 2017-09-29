package com.airwire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airwire.model.User;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAll(); 
}