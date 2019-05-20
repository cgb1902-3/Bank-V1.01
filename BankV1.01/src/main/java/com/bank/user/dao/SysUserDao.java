package com.bank.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bank.user.entity.SysCard;
import com.bank.user.entity.SysUserAdmin;
public interface SysUserDao {
	/**
	 * 根据id查询客户信息
	 * @param id
	 * @return
	 */
	List<SysCard> findObjectsById(Integer id);

	/**注册功能*/
	SysUserAdmin register(SysUserAdmin SysUserAdmin);

	/**
	 * 登录功能
	 * @param username 用户名
	 * @param password 密码
	 * @return 生成的JWT的token
	 */

	//String login(String username,String password);
	/**查询所有用户信息,返回是否存在*/
	boolean findObjectsByName(String username);
	/**增加用户信息*/
	int insertObjects();
	/**根据用户名查询用户对象*/
	SysUserAdmin findUserByUserName(String username);
	/**修改用户密码*/
	int updatePassword(@Param("password")String password);
	

}
