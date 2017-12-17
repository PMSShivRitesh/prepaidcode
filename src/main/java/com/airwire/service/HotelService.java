package com.airwire.service;

import java.util.List;

import com.airwire.model.HotelInfo;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface HotelService {

	HotelInfo save(HotelInfo hotelInfo);

	HotelInfo findById(Long hotelId);

	List<HotelInfo> findAll();
}
