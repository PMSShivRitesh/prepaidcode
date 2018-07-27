package com.airwire.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airwire.dto.PrepaidCodeDeatail;
import com.airwire.service.PrepaidCodeService;
import com.airwire.service.SmsService;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@RestController
public class PrepaidCodeRestController {

	@Autowired
	PrepaidCodeService prepaidCodeService;
	
	@Autowired
	SmsService smsService;
	
	@RequestMapping("prepaidcodestatusbyday")
	public PrepaidCodeDeatail getprepaidcode(@RequestParam("plan") Long plan,@RequestParam(required=false) Long orgId,Principal principal)
	{
		PrepaidCodeDeatail prepaidCodeDeatail = prepaidCodeService.getPrepaidCode(plan,principal.getName(),orgId);
		return prepaidCodeDeatail;
	}
	
	
	@RequestMapping("license")
	public Map<String,String> license()	{
		Map<String,String> dataMap=new HashMap<String, String>();
		String data = smsService.getLicencens();
		dataMap.put("lDate", data);
		return dataMap;
	}
	
	
}
