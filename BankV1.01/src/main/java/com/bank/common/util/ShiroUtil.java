package com.bank.common.util;

import org.apache.shiro.SecurityUtils;

import com.bank.sys.entity.SysUser;

public abstract class ShiroUtil {
	public static SysUser getUser(){
		return (SysUser)SecurityUtils.getSubject().getPrincipal();
	}
}
