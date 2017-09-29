package com.airwire.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airwire.dto.PrepaidCodeDeatail;
import com.airwire.service.PrepaidCodeService;
import com.airwire.service.SmsService;

@RestController
public class PrepaidCodeRestController {

	@Autowired
	PrepaidCodeService prepaidCodeService;
	
	@Autowired
	SmsService smsService;
	
	@RequestMapping("prepaidcodestatusbyday")
	public PrepaidCodeDeatail getprepaidcode(@RequestParam("days") String days)
	{
		PrepaidCodeDeatail prepaidCodeDeatail = prepaidCodeService.getPrepaidCode(days);
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