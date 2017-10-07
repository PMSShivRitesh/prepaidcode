package com.airwire.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@Entity
@Table(name="PREPAIDCODE")
public class PrepaidCode {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String prepaidCode;
	
	private Date date;
	
	private Integer days;
	
	private int amount;
	
	private String status;
	
	private String wuserid;
	
	private String wpassword;
	
	
	@ManyToOne
	private User user;
	
	@ManyToOne()
    @JoinColumn(name ="hotelInfo_id")
	private HotelInfo hotelInfo;
	
	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}
	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}
	
	@OneToOne
	@JoinColumn(name="usedPlanInfo_id")
	private UsedPlanInfo usedPlanInfo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrepaidCode() {
		return prepaidCode;
	}
	public void setPrepaidCode(String prepaidCode) {
		this.prepaidCode = prepaidCode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UsedPlanInfo getUsedPlanInfo() {
		return usedPlanInfo;
	}
	public void setUsedPlanInfo(UsedPlanInfo usedPlanInfo) {
		this.usedPlanInfo = usedPlanInfo;
	}
	public String getWuserid() {
		return wuserid;
	}
	public void setWuserid(String wuserid) {
		this.wuserid = wuserid;
	}
	public String getWpassword() {
		return wpassword;
	}
	public void setWpassword(String wpassword) {
		this.wpassword = wpassword;
	}
	
}
