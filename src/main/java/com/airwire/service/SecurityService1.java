package com.airwire.service;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface SecurityService1 {
	String findLoggedInUsername();
	void autologin(String username, String password);
}
