package com.airwire.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airwire.model.HotelInfo;
import com.airwire.model.UsedPlanInfo;
import com.airwire.service.PrepaidCodeService;
import com.airwire.service.SmsService;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {

	@Autowired
	PrepaidCodeService prepaidCodeService;

	@Override
	public String sendSms(String prepaidCode,String userName,Long orgId) {
		String response = "";
		UsedPlanInfo usedPlanInfo = prepaidCodeService.getUsedPlanInfoByCode(prepaidCode,userName,orgId);
		HotelInfo hotelInfo = usedPlanInfo.getUser().getHotelInfo();
		//String message = "Welcome To " + hotelInfo.getHotelName() + " WiFi Zone" + " your WiFi Prepaid code for ";
		String message = hotelInfo.getMessage();
		if(hotelInfo.getControllerName().equalsIgnoreCase("WIFISOFT")){
			message.replace("<prepaidcode>", usedPlanInfo.getPrepaidCode().getPrepaidCode());
		}else{
			message=message.replace("<userid>", usedPlanInfo.getPrepaidCode().getWuserid());
			message=message.replace("<password>", usedPlanInfo.getPrepaidCode().getWpassword());
		}
		
		if (usedPlanInfo.getDays().equals("7")) {
			//message = message + "1 Week";
			message=message.replace("<plan>", "1 Week");
		} else if (usedPlanInfo.getDays().equals("30")) {
			//message = message + "1 Month";
			message=message.replace("<plan>", "1 Month");
		} else {
			//message = message + usedPlanInfo.getDays() + " day";
			message=message.replace("<plan>", usedPlanInfo.getDays() + " day");
		}

		//message = message + " is " + prepaidCode;
		String mobiles = usedPlanInfo.getMobileNo();
		// Your authentication key
		// Multiple mobiles numbers separated by comma
		// Sender ID,While using route4 sender id should be 6 characters long.
		// Your message to send, Add URL encoding here.
		// Prepare Url
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		// encoding message
		@SuppressWarnings("deprecation")
		String encoded_message = URLEncoder.encode(message);


		String mainUrl="";
		StringBuilder sbPostData;
		
		if(hotelInfo.getSmsVendor().equalsIgnoreCase("Cellx")){
			
			/*
			 * http://49.50.67.32/smsapi/httpapi.jsp?username=CITRUS02&password=
			 * CITRUS02$123&from=CITRUS&to=9960801981&text=hello+world&coding=0
			 */
			    mainUrl = "http://49.50.67.32/smsapi/httpapi.jsp?";
				sbPostData = new StringBuilder(mainUrl);
				sbPostData.append("username=" + hotelInfo.getUserId());
				sbPostData.append("&password=" + hotelInfo.getPassword());
				sbPostData.append("&from=" + hotelInfo.getSenderId());
				sbPostData.append("&to=" + mobiles);
				sbPostData.append("&text=" + encoded_message);
		}else{
			
			/*
			 * http://www.smswave.in/panel/sendsms.php?user=demodemo
			 * &password=sms123Pwd &sender=ICUBEX
			 * &PhoneNumber=9199xxxxxxxx&Text=Welcome%20to%20SMS%20wave%20API.
			 * //Send SMS API
			 */
			
			 mainUrl = "http://smswave.in/panel/sendsms.php?";
			// Prepare parameter string
				sbPostData = new StringBuilder(mainUrl);
				sbPostData.append("user=" + hotelInfo.getUserId());
				sbPostData.append("&password=" + hotelInfo.getPassword());
				sbPostData.append("&sender=" + hotelInfo.getSenderId());
				sbPostData.append("&PhoneNumber=" + mobiles);
				sbPostData.append("&Text=" + encoded_message);
		}
		
		// final string
		mainUrl = sbPostData.toString();
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response

			String test = "";
			while ((response = reader.readLine()) != null)
				// print response
				test = test + response;
			response = test;

			// finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;
	}
	
	
	
	@Override
	public String getLicencens() {
		String response = "";
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "http://airwiresolutions.com/data.php";
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String test = "";
			while ((response = reader.readLine()) != null)
				test = test + response;
				response = test;
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;
	}
}
