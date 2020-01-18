package com.airwire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.airwire.model.HotelInfo;
import com.airwire.model.User;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.username=:username and u.active=1")
	User findByUsername1(String username);
    
	User findByUsername(String username);
    
	List<User> findAll();
    
	List<User> findByHotelInfo(HotelInfo hotelInfo);
    
    @Query("SELECT u FROM User u WHERE u.id=:id")
    User getUserById(@Param("id") Long id);
}