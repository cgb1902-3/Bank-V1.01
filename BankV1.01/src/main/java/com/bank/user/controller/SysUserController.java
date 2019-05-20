package com.bank.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bank.user.service.SysUserService;
import com.bank.user.vo.JsonResult;

@RequestMapping("/user/")

public class SysUserController {
	private SysUserService  sysUserService;
	@RequestMapping("doUserListUI")
	public String doUserListUI(){
		return "sys/user_list";
	}
	@ResponseBody
	@RequestMapping("dofindObjectsById")
	public JsonResult dofindObjectsById(Integer id){
		return new JsonResult(sysUserService.findObjectsById(id));
	}
	@RequestMapping("doLoginUser")
	@ResponseBody
	public JsonResult doLogin(String username,String password){
		//1.获取Subject对象
		Subject subject=SecurityUtils.getSubject();
		//2.通过Subject提交用户信息,交给shiro框架进行认证操作
		//2.1对用户进行封装
		UsernamePasswordToken token=
				new UsernamePasswordToken(
						username,//身份信息
						password);//凭证信息
		//2.2对用户信息进行身份认证
		subject.login(token);
		//分析:
		//1)token会传给shiro的SecurityManager
		//2)SecurityManager将token传递给认证管理器
		//3)认证管理器会将token传递给realm
		return new JsonResult("login ok");
	}
	@ResponseBody
	@RequestMapping("doUpdatePassword")
	public JsonResult doUpdatePassword(String userPassword,
			String newPassword, String cfgPassword){
		sysUserService.updatePassword(userPassword, newPassword, cfgPassword);
		return new JsonResult("update ok");
	}

}
