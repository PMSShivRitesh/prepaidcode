package com.airwire.service;

import java.util.List;

import com.airwire.model.HotelInfo;
import com.airwire.model.Plan;

public interface PlanService {

	Plan findById(Long id);

	List<Plan> findAll();

	List<Plan> findByHotelInfo(Long hotelId);

	List<Plan> findByHotelInfo(HotelInfo hotelInfo);

	Plan save(Plan plan);
}
