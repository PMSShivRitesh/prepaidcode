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

	@RequestMapping("generateprepaidcode")
	public String generatePrepaidCode(Principal principal, Model model) {
		
		User user=userService.findByUsername(principal.getName());
		for (Role role : user.getRoles()){
			 model.addAttribute("role", role.getName());
	    }
		model.addAttribute("userName", principal.getName());
		return "home/generateprepaidcode";
	}

	
	
	@RequestMapping(value ="saveusedplaninfo", method =RequestMethod.POST)
	public String printPrepaidCode(@ModelAttribute("command") UsedPlanInfo usedPlanInfo, Principal principal, Model model) {
		usedPlanInfo.setUser(userService.findByUsername(principal.getName()));
		usedPlanInfo = prepaidCodeService.saveRecord(usedPlanInfo);
		model.addAttribute("userName", principal.getName());
		if (usedPlanInfo != null) {
			String prepaidCode=usedPlanInfo.getPrepaidCode().getPrepaidCode()!=null?usedPlanInfo.getPrepaidCode().getPrepaidCode():usedPlanInfo.getPrepaidCode().getWuserid();
			return "redirect:printprepaidcodepage?prepaidCode="+prepaidCode;
		} else {
			model.addAttribute("usedPlanInfo", "This Plan is Not available");
			return "home/genrateprepaidcode";
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
		return "admin/generatebulkprepaidcode";
	}
	
	@RequestMapping(value ="printprepaidcodepage", method =RequestMethod.GET)
	public String myReport(@RequestParam(required=true) String prepaidCode,Principal principal,Model model){
	
		UsedPlanInfoDTO usedPlanInfoDTO = prepaidCodeService.getUsedPlanDTOByPrepaidCode(prepaidCode);
		model.addAttribute("userName", principal.getName());
		model.addAttribute("usedPlanInfo", usedPlanInfoDTO);
		return "home/printprepaidcodepage";
	}
}
