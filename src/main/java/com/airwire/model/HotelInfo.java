package com.airwire.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@Entity
@Table(name="hotelinfo")
public class HotelInfo {
	
	private Long id;
	private String hotelName;
	private String senderId;
	private String password;
	private String userId;
	private String controllerName;
	private int warnPoint;
	private String smsVendor;
	@Column(length=1000)
	private String message;
	
	
	private Set<User> user;
	private Set<PrepaidCode> prepaidCode;
	
	private Set<UsedPlanInfo> usedPlanInfo;
	
	private Set<Plan> plan;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@OneToMany(mappedBy="hotelInfo")
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
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
	
	@OneToMany(mappedBy="hotelInfo")
	public Set<PrepaidCode> getPrepaidCode() {
		return prepaidCode;
	}
	public void setPrepaidCode(Set<PrepaidCode> prepaidCode) {
		this.prepaidCode = prepaidCode;
	}
	
	@OneToMany(mappedBy="hotelInfo")
	public Set<UsedPlanInfo> getUsedPlanInfo() {
		return usedPlanInfo;
	}
	public void setUsedPlanInfo(Set<UsedPlanInfo> usedPlanInfo) {
		this.usedPlanInfo = usedPlanInfo;
	}
	
	@OneToMany(mappedBy="hotelInfo")
	public Set<Plan> getPlan() {
		return plan;
	}
	public void setPlan(Set<Plan> plan) {
		this.plan = plan;
	}

}
