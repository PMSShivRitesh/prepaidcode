package com.airwire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airwire.dao.PlanRepository;
import com.airwire.model.HotelInfo;
import com.airwire.model.Plan;
import com.airwire.service.HotelService;
import com.airwire.service.PlanService;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@Service("planService")
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanRepository planRepository;
	
	@Autowired
	HotelService hotelService;
	
	@Override
	public Plan findById(Long id) {
		// TODO Auto-generated method stub
		return planRepository.findById(id);
	}
	
	@Override
	public List<Plan> findAll() {
		// TODO Auto-generated method stub
		return planRepository.findAll();
	}
	
	@Override
	public List<Plan> findByHotelInfo(Long hotelId){
		HotelInfo hotelInfo = hotelService.findById(hotelId);
		return planRepository.findByHotelInfo(hotelInfo);
	}
	
	@Override
	public List<Plan> findByHotelInfo(HotelInfo hotelInfo){
		return planRepository.findByHotelInfo(hotelInfo);
	}

	@Override
	public Plan save(Plan plan) {
		// TODO Auto-generated method stub
		return planRepository.save(plan);
	}

}
