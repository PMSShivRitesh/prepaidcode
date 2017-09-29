package com.airwire.dto;
import java.util.Date;

public class UsedPlanInfoDTO {

	private Integer id;
	private String prepaidCode;
	private String plan;
	private Integer amount;
	private Date date;
	private String guestName;
	private String roomNo;
	private String photoIdProofType;
	private String photoIdProof;
	private String mobileNo;
	private String address;
	private String emailId;
	private String hotelName;
	
	private String wuserid;
	private String wpassword;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrepaidCode() {
		return prepaidCode;
	}

	public void setPrepaidCode(String prepaidCode) {
		this.prepaidCode = prepaidCode;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
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

	public void setPhotoIdProofType(String photoIdProofType) {
		this.photoIdProofType = photoIdProofType;
	}

	public String getPhotoIdProofType() {
		return photoIdProofType;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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
