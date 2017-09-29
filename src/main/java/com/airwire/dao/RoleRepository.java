package com.airwire.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.airwire.model.Role;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findById(Long id);
}