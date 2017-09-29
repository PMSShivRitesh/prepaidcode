package com.airwire.dto;

public class PrepaidCodeDeatail {

	private String prepaidCode;
	private String wuserid;
	private String wpassword;
	private int amount;
	private int size;
	private int warnPoint;
	public String getPrepaidCode() {
		return prepaidCode;
	}
	public void setPrepaidCode(String prepaidCode) {
		this.prepaidCode = prepaidCode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
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
	public int getWarnPoint() {
		return warnPoint;
	}
	public void setWarnPoint(int warnPoint) {
		this.warnPoint = warnPoint;
	}
}
