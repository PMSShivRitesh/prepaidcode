package com.airwire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airwire.dao.HotelInfoRepository;
import com.airwire.dao.UserRepository;
import com.airwire.model.HotelInfo;
import com.airwire.model.User;
import com.airwire.service.HotlService;

@Service("hotlService")
public class HotelServiceImpl implements HotlService {

	@Autowired
	HotelInfoRepository hotelInfoRepository;
	
	 @Autowired
	   private UserRepository userRepository;
	
	@Override
	public HotelInfo save(HotelInfo hotelInfo, User user) {
		hotelInfo = hotelInfoRepository.save(hotelInfo);
		user.setHotlInfo(hotelInfo);
		userRepository.save(user);
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
