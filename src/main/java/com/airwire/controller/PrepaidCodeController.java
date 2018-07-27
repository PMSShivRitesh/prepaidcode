package com.airwire.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.airwire.dto.ReportDTO;
import com.airwire.dto.UsedPlanInfoDTO;
import com.airwire.model.Role;
import com.airwire.model.UsedPlanInfo;
import com.airwire.model.User;
import com.airwire.service.HotelService;
import com.airwire.service.PlanService;
import com.airwire.service.PrepaidCodeService;
import com.airwire.service.UserService;

/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@Controller
public class PrepaidCodeController {

	@Autowired
	PrepaidCodeService prepaidCodeService;

	@Autowired
	UserService userService;
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	PlanService planService;

	@RequestMapping("generateprepaidcode")
	public String generatePrepaidCode(Principal principal, Model model) {
		
		User user=userService.findByUsername(principal.getName());
		for (Role role : user.getRoles()){
			 model.addAttribute("role", role.getName());
	    }
		
		if(user.getHotelInfo()==null){
			model.addAttribute("planList", planService.findAll());
		}else{
			model.addAttribute("planList", planService.findByHotelInfo(user.getHotelInfo()));
		}
		
		model.addAttribute("orgList",hotelService.findAll());
		model.addAttribute("userName", principal.getName());
		return "home/generateprepaidcode";
	}

	
	
	@RequestMapping(value ="saveusedplaninfo", method =RequestMethod.POST)
	public String printPrepaidCode(@ModelAttribute("command") UsedPlanInfo usedPlanInfo, Principal principal, Model model,@RequestParam(required = false) Long orgId) {
		usedPlanInfo.setUser(userService.findByUsername(principal.getName()));
		usedPlanInfo = prepaidCodeService.saveRecord(usedPlanInfo,orgId);
		model.addAttribute("userName", principal.getName());
		if (usedPlanInfo != null) {
			if(usedPlanInfo.getPrepaidCode()!=null){
				String prepaidCode=usedPlanInfo.getPrepaidCode().getPrepaidCode()!=null?usedPlanInfo.getPrepaidCode().getPrepaidCode():usedPlanInfo.getPrepaidCode().getWuserid();
				if(orgId!=null && orgId>0){
					return "redirect:printprepaidcodepage?prepaidCode="+prepaidCode+"&orgId="+orgId;
				}else{
					return "redirect:printprepaidcodepage?prepaidCode="+prepaidCode+"&orgId=";
				}
			}else{
				User user=userService.findByUsername(principal.getName());
				for (Role role : user.getRoles()){
					 model.addAttribute("role", role.getName());
			    }
				model.addAttribute("orgList",hotelService.findAll());
				model.addAttribute("userName", principal.getName());
				
				model.addAttribute("usedPlanInfo", "This Plan is Not available");
				return "redirect:generateprepaidcode";
			}
		} else {
			User user=userService.findByUsername(principal.getName());
			for (Role role : user.getRoles()){
				 model.addAttribute("role", role.getName());
		    }
			model.addAttribute("orgList",hotelService.findAll());
			model.addAttribute("userName", principal.getName());
			
			model.addAttribute("usedPlanInfo", "This Plan is Not available");
			return "redirect:generateprepaidcode";
		}
	}
	
	@RequestMapping(value="report", method =RequestMethod.GET)
	public String getReport(Model model){
		model.addAttribute("usedPlanInfoDTO",null);
		return "admin/report";
	}
	
	@RequestMapping(value="report", method =RequestMethod.POST)
	public String getReportByDate(@ModelAttribute("command") ReportDTO reportDTO,Model model){
		model.addAttribute("usedPlanInfoDTO",prepaidCodeService.getReportByDate(reportDTO.getFromDate(),reportDTO.getToDate()));
		return "admin/report";
	}
	@RequestMapping("generatebulkprepaidcode")
	public String uploadcsv(Model model,Principal principal){
		model.addAttribute("userName", principal.getName());
		model.addAttribute("orgList",hotelService.findAll());
		User user = userService.findByUsername(principal.getName());
		if(user.getHotelInfo()==null){
			model.addAttribute("planList", planService.findAll());
		}else{
			model.addAttribute("planList", planService.findByHotelInfo(user.getHotelInfo()));
		}
		return "admin/generatebulkprepaidcode";
	}
	
	@RequestMapping(value ="printprepaidcodepage", method =RequestMethod.GET)
	public String myReport(@RequestParam(required=true) String prepaidCode,@RequestParam(required=false) Long orgId,Principal principal,Model model){
	
		UsedPlanInfoDTO usedPlanInfoDTO = prepaidCodeService.getUsedPlanDTOByPrepaidCode(prepaidCode,principal.getName(),orgId);
		if(usedPlanInfoDTO!=null){
			usedPlanInfoDTO.setOrgId(orgId);
		}
		model.addAttribute("userName", principal.getName());
		model.addAttribute("usedPlanInfo", usedPlanInfoDTO);
		return "home/printprepaidcodepage";
	}
}
