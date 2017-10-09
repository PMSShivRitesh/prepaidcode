package com.airwire.service;

import com.airwire.model.HotelInfo;
import com.airwire.model.User;

public interface HotlService {

	HotelInfo save(HotelInfo hotlInfo, User user);
}
