package com.bank.login.service;



import java.util.Map;

import com.bank.sys.entity.SysUser;

public interface SysUserService {
	
	/**
	 * 修改密码
	 * @param password
	 * @param newPassword
	 * @param cfgPassword
	 * @return
	 */
	int updatePassword(
			String password,
			String newPassword,
			String cfgPassword);
	 
	 Map<String,Object> findObjectById(
			 Integer id);
	
	 /**
	  * 更新用户以及用户对应的角色信息
	  * @param entity
	  * @param roleIds
	  * @return
	  */
	 int updateObject(SysUser entity,
			 Integer[] roleIds);
	/**
	   * 保存用户以及用户对应的角色信息
	   * @param entity
	   * @param roleIds
	   * @return
	   */
	  int saveObject(SysUser entity,
			         Integer[] roleIds);

	  int validById(Integer id,Integer valid,String modifiedUser);
}
