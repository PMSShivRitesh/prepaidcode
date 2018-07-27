package com.airwire.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airwire.dto.PlanDto;
import com.airwire.model.HotelInfo;
import com.airwire.model.Plan;
import com.airwire.service.HotelService;
import com.airwire.service.PlanService;

@Controller
public class OrgPlanCotroller {

	@Autowired
	HotelService hotelService;
	
	@Autowired
	PlanService planService;
	
	@RequestMapping(value = "createplan", method = RequestMethod.GET)
	public String createPlan(Model model, Principal pricipal) {
		String userName = pricipal.getName();
		model.addAttribute("userName", userName);
		List<HotelInfo> hotelList=hotelService.findAll();
		model.addAttribute("orgList",hotelList);
		return "sysadmin/createplan";
	}
	
	@RequestMapping(value = "/createplan", method = RequestMethod.POST)
	public String savePlan(@ModelAttribute("command") PlanDto planDto, Principal principal,
			Model model) {

		
		HotelInfo hotelInfo = hotelService.findById(planDto.getOrgId());
		Plan plan = new Plan();
		
		plan.setName(planDto.getName());
		plan.setDescription(planDto.getDescription());
		plan.setHotelInfo(hotelInfo);
		
		plan = planService.save(plan);
		
		model.addAttribute("msg","Plan Creted Succesfully !!");
		return "redirect:createplan";
	}
	
}
