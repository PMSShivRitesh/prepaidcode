package com.airwire.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airwire.service.SmsService;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@RestController
public class SendSmsController {

	@Autowired
	SmsService smsService;
	
	@RequestMapping("sendprepaidcodeassms")
	public String myReport(@RequestParam(required=true) String prepaidCode,@RequestParam(required=false) Long orgId,Principal principal){
		return smsService.sendSms(prepaidCode,principal.getName(),orgId);
	}

}
