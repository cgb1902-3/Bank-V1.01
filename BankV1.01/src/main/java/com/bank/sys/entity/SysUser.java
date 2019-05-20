package com.bank.sys.entity;

import java.io.Serializable;
import java.sql.Date;

public class SysUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7194703277910271934L;
	private Integer id;
	private String userId;
	private String userName;
	private String userPassword;
	private String idNo;
	private String userStatus;
	private String userAddress;
	private Date startTime;
	private String startAddress;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getStartAddress() {
		return startAddress;
	}
	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", idNo=" + idNo + ", userStatus=" + userStatus + ", userAddress=" + userAddress + ", startTime="
				+ startTime + ", startAddress=" + startAddress + "]";
	}
	
	
}
