package com.airwire.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airwire.model.HotelInfo;
import com.airwire.model.Plan;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface PlanRepository extends JpaRepository<Plan, Long>{
	
	Optional<Plan> findById(Long id);
	
	List<Plan> findByHotelInfo(HotelInfo hotelInfo);
}