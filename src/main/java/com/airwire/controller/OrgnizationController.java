package com.airwire.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airwire.model.HotelInfo;
import com.airwire.service.HotelService;

/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@Controller
public class OrgnizationController {

	@Autowired
	HotelService hotelService;
	
	@RequestMapping(value = "createorganization", method = RequestMethod.GET)
	public String hotelSetup(Model model, Principal pricipal) {
		String userName = pricipal.getName();
		model.addAttribute("userName", userName);
		List<HotelInfo> hotelList=hotelService.findAll();
		model.addAttribute("orgList",hotelList);
		return "sysadmin/createorg";
	}
}
