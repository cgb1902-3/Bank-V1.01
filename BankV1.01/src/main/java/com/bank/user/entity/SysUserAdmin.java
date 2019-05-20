package com.bank.user.entity;
/**
 * 此类封装用户注册信息
 * @author UID
 */
public class SysUserAdmin {
	private Integer id; //用户id
	private String username;//用户名
	private String password;//用户密码
	private Integer status;//用户状态信息 挂失=1/正常=0
	private Integer salt;
	public Integer getSalt() {
		return salt;
	}
	public void setSalt(Integer salt) {
		this.salt = salt;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SysUserAdmin [id=" + id + ", username=" + username + ", password=" + password + ", status=" + status
				+ "]";
	}
	public SysUserAdmin(Integer id, String username, String password, Integer status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
	}
	public SysUserAdmin() {
		// TODO Auto-generated constructor stub
	}
}
