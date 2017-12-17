package com.airwire.service;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface SmsService {

	String sendSms(String prepaidCode,String userName,Long orgId);

	String getLicencens();

}
