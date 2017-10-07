package com.airwire.controller;

import java.lang.reflect.InvocationTargetException;
import java.security.Principal;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airwire.dto.HotelInfoDto;
import com.airwire.model.HotelInfo;
import com.airwire.model.User;
import com.airwire.service.HotlService;
import com.airwire.service.UserService;

@Controller
public class HotelController {

	@Autowired
	HotlService hotlService;
	@Autowired
    private UserService userService;
	
	 @RequestMapping(value = "/hotelsetup", method = RequestMethod.GET)
	    public String hotelSetup(Model model,Principal pricipal) {
	    	String userName=pricipal.getName();
	    	User user = userService.findByUsername(userName);
	    	HotelInfo hotelInfo = user.getHotlInfo();
	    	if(hotelInfo==null){
	    		hotelInfo = new HotelInfo();
	    	}
	    	model.addAttribute("hotelInfo",hotelInfo);
	    	model.addAttribute("userName",userName);
	        return "admin/hotelsetup";
	    }
	 
	 @RequestMapping(value = "/hotelsetup", method = RequestMethod.POST)
	    public String savehotelSetup(@ModelAttribute("command") HotelInfoDto hotelInfoDto, Principal principal, Model model) {
	    	
		 String userName=principal.getName();
	    	User user = userService.findByUsername(userName);
	    	//Set<User> userSet= new HashSet<User>();
	    	//userSet.add(user);
		 	HotelInfo hotelInfo = new HotelInfo();
		 	try {
				BeanUtils.copyProperties(hotelInfo, hotelInfoDto);
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		 	//hotelInfo.setUser(userSet);
	    	hotelInfo=hotlService.save(hotelInfo,user);
	    	model.addAttribute("hotelInfo",hotelInfo);
	        return "redirect:hotelsetup";
	    }
}
