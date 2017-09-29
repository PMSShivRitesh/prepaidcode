package com.airwire.model;

import java.util.Date;

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
@Table(name="usedplaninfo")
public class UsedPlanInfo {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="prepaidCode_id")
	private PrepaidCode prepaidCode;
	private Integer amount;
	private Date date;
	private String guestName;
	private String roomNo;
	private String photoIdProofType;
	private String photoIdProof;
	private String mobileNo;
	private String address;
	private String emailId;
	private String days;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PrepaidCode getPrepaidCode() {
		return prepaidCode;
	}

	public void setPrepaidCode(PrepaidCode prepaidCode) {
		this.prepaidCode = prepaidCode;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getPhotoIdProofType() {
		return photoIdProofType;
	}

	public void setPhotoIdProofType(String photoIdProofType) {
		this.photoIdProofType = photoIdProofType;
	}

	public String getPhotoIdProof() {
		return photoIdProof;
	}

	public void setPhotoIdProof(String photoIdProof) {
		this.photoIdProof = photoIdProof;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}
}
