package com.airwire.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airwire.model.HotelInfo;

/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface HotelInfoRepository extends JpaRepository<HotelInfo, Long>{

	Optional<HotelInfo> findById(Long hotelId);

}
