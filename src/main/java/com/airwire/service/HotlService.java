package com.airwire.service;

import java.util.List;

import com.airwire.model.HotelInfo;
import com.airwire.model.User;

public interface HotlService {

	HotelInfo save(HotelInfo hotlInfo, User user);

	HotelInfo findById(Long hotelId);

	List<HotelInfo> findAll();
}
