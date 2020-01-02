package com.airwire.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airwire.model.Role;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findById(Long id);
}