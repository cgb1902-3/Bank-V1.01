package com.bank.user.service.impl;

import java.awt.datatransfer.StringSelection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.bank.user.common.exception.ServiceException;
import com.bank.user.dao.SysUserDao;
import com.bank.user.entity.SysCard;
import com.bank.user.entity.SysUserAdmin;
import com.bank.user.service.SysUserService;

public class SysUserServiceImpl implements SysUserService{
	@Autowired
	private SysUserDao sysUserDao;
	@Override
	public List<SysCard> findObjectsById(Integer id) {
		List<SysCard> records = sysUserDao.findObjectsById(id);
		return  records;
	}
	/**此方法实现注册功能*/
	@Override
	public boolean register(SysUserAdmin sysUserAdmin) {
		//1验证用户名是否存在或者为空,
		if(StringUtils.isEmpty(sysUserAdmin.getUsername()))
			throw new ServiceException("用户名不能为空");
		if(sysUserAdmin.getUsername().isEmpty())
			throw new ServiceException("用户名已存在");
		//2注册

		return true;
	}
	@Override
	public boolean findObjectsByName(String username) {
		return sysUserDao.findObjectsByName(username);
	}
	@Override
	public int updatePassword(String userPassword, String newPassword, String cfgPassword) {
		//1.判定原密码是否正确
		if(StringUtils.isEmpty(userPassword)) throw new 
		IllegalArgumentException("用户密码不能为空");
		//2.判断新密码与确认密码是否相同
		if(StringUtils.isEmpty(newPassword)) throw new
		IllegalArgumentException("新密码不能为空");
		if(StringUtils.isEmpty(cfgPassword)) throw new 
		IllegalArgumentException("确认密码不能为空");
		if(!newPassword.equals(cfgPassword)) throw new 
		IllegalArgumentException("新密码和确认密码不一致");
		//3.将密码更新到数据库
		int rows=sysUserDao.updatePassword(userPassword);
		return rows;
	}






}
