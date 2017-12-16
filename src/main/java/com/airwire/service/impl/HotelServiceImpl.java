package com.airwire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airwire.dao.HotelInfoRepository;
import com.airwire.model.HotelInfo;
import com.airwire.service.HotelService;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelInfoRepository hotelInfoRepository;
	
	@Override
	public HotelInfo save(HotelInfo hotelInfo) {
		hotelInfo = hotelInfoRepository.save(hotelInfo);
		//user.setHotlInfo(hotelInfo);
		//userRepository.save(user);
    	return hotelInfo;
	}

	@Override
	public HotelInfo findById(Long hotelId) {
		return hotelInfoRepository.findById(hotelId);
	}

	@Override
	public List<HotelInfo> findAll() {
		return hotelInfoRepository.findAll();
	}

}
