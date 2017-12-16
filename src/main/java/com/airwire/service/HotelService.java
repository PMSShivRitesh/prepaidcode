package com.airwire.service;

import java.util.List;

import com.airwire.model.HotelInfo;

public interface HotelService {

	HotelInfo save(HotelInfo hotlInfo);

	HotelInfo findById(Long hotelId);

	List<HotelInfo> findAll();
}
