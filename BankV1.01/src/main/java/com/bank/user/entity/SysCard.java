package com.bank.user.entity;

import java.io.Serializable;
import java.util.Date;

public class SysCard implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String cardStatus;
	private String cardPassword;
	private Integer cardMoney;
	private Date startTime;
	private Date startAddress;
	private Date accountAddress;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}
	public String getCardPassword() {
		return cardPassword;
	}
	public void setCardPassword(String cardPassword) {
		this.cardPassword = cardPassword;
	}
	public Integer getCardMoney() {
		return cardMoney;
	}
	public void setCardMoney(Integer cardMoney) {
		this.cardMoney = cardMoney;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getStartAddress() {
		return startAddress;
	}
	public void setStartAddress(Date startAddress) {
		this.startAddress = startAddress;
	}
	public Date getAccountAddress() {
		return accountAddress;
	}
	public void setAccountAddress(Date accountAddress) {
		this.accountAddress = accountAddress;
	}
	@Override
	public String toString() {
		return "SysCardVo [id=" + id + ", username=" + username + ", cardStatus=" + cardStatus + ", cardPassword="
				+ cardPassword + ", cardMoney=" + cardMoney + ", startTime=" + startTime + ", startAddress="
				+ startAddress + ", accountAddress=" + accountAddress + "]";
	}
	public SysCard() {
	}
	public SysCard(Integer id, String username, String cardStatus, String cardPassword, Integer cardMoney,
			Date startTime, Date startAddress, Date accountAddress) {
		super();
		this.id = id;
		this.username = username;
		this.cardStatus = cardStatus;
		this.cardPassword = cardPassword;
		this.cardMoney = cardMoney;
		this.startTime = startTime;
		this.startAddress = startAddress;
		this.accountAddress = accountAddress;
	}
	
}
