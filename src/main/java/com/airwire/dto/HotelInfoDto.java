package com.airwire.dto;

/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public class HotelInfoDto {
	
	private Long id;
	private String hotelName;
	private String senderId;
	private String password;
	private String userId;
	private String controllerName;
	private int warnPoint;
	private String smsVendor;
	private String message;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getControllerName() {
		return controllerName;
	}
	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}
	public int getWarnPoint() {
		return warnPoint;
	}
	
	public void setWarnPoint(int warnPoint) {
		this.warnPoint = warnPoint;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSmsVendor() {
		return smsVendor;
	}
	public void setSmsVendor(String smsVendor) {
		this.smsVendor = smsVendor;
	}

}
