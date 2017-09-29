package com.airwire.service;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface SecurityService {
	String findLoggedInUsername();
	void autologin(String username, String password);
}
