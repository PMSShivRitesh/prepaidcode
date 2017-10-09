package com.airwire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airwire.dao.HotelInfoRepository;
import com.airwire.dao.UserRepository;
import com.airwire.model.HotelInfo;
import com.airwire.model.User;

@Service("hotlService")
public class HotlService implements com.airwire.service.HotlService {

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

}
