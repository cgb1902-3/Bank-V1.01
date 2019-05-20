package com.bank.user.service;

import java.util.List;
import java.util.Map;

import com.bank.user.entity.SysCard;
import com.bank.user.entity.SysUserAdmin;

public interface SysUserService {
	/**根据id查询用户信息*/
	List<SysCard> findObjectsById(Integer id);
	 /**
     * 注册功能
     */
    boolean register(SysUserAdmin sysUserAdmin);
    /**查询所有用户信息,返回是否存在*/
    boolean findObjectsByName(String username);
    /**
     * 修改用户密码
     * @param userPassword 原密码
     * @param newPassword 新密码
     * @param cfgPassword 再次确认密码
     * @return
     */
    int updatePassword(
			String userPassword,
			String newPassword,
			String cfgPassword);

}
