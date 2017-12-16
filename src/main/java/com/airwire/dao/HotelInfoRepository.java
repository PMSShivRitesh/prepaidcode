package com.airwire.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airwire.model.HotelInfo;


public interface HotelInfoRepository extends JpaRepository<HotelInfo, Long>{

	HotelInfo findById(Long hotelId);

}
