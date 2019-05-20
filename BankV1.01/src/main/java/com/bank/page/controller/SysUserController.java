package com.bank.page.controller;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bank.common.util.ShiroUtil;
import com.bank.common.vo.JsonResult;
import com.bank.login.service.SysUserService;
import com.bank.sys.entity.SysUser;

@RequestMapping("/user/")
@Controller
public class SysUserController {
	   @Autowired
	   private SysUserService sysUserService;
	   
	   @RequestMapping("doPwdEditUI")
	   public String doPwdEditUI(){
		   return "sys/pwd_edit";
	   }
	   
	   @RequestMapping("doUpdatePassword")
	   @ResponseBody
	   public JsonResult doUpdatePassword(String pwd,String newPwd,String cfgPwd) {
		   sysUserService.updatePassword(pwd, newPwd, cfgPwd);
		   return new JsonResult("update ok");
	   }
	   
	   @RequestMapping("doLogin")
	   @ResponseBody
	   public JsonResult doLogin(boolean isRememberMe,String username,String password){
		   //提交用户信息到业务层
		   //1.获取主体对象subject
		   Subject subject=SecurityUtils.getSubject();
		   //2.提交信息(提交给shiro的securityManager)
		   UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		   if(isRememberMe){
			   token.setRememberMe(true);
		   }
		   subject.login(token);//执行登录认证操作
		   return new JsonResult("login ok");
	   }
	   
	   @RequestMapping("doUserListUI")
	   public String doUserListUI() {
		   return "sys/user_list";
	   }
	   @RequestMapping("doUserEditUI")
	   public String doUserEditListUI() {
		   return "sys/user_edit";
	   }
	   @RequestMapping("doFindObjectById")
	   @ResponseBody
	   public JsonResult doFindObjectById(
			   Integer id) {
		   Map<String,Object> map=
		   sysUserService.findObjectById(id);
		   return new JsonResult(map);
	   }
	   @RequestMapping("doUpdateObject")
	   @ResponseBody
	   public JsonResult doUpdateObject(
			   SysUser entity,
			   Integer[] roleIds) {
		   sysUserService.updateObject(entity, roleIds);
		   return new JsonResult("update ok");
	   }
	   @RequestMapping("doSaveObject")
	   @ResponseBody
	   public JsonResult doSaveObject(
			  SysUser entity,
			  Integer[] roleIds) {
		      sysUserService.saveObject(entity, roleIds);
		      return new JsonResult("save ok");
	   }
	   
	   @RequestMapping("doValidById")
	   @ResponseBody
	   public JsonResult doValidById(Integer id,Integer valid) {
		   //获取登录用户信息
		   SysUser user=ShiroUtil.getUser();
		   sysUserService.validById(id,
				   valid, user.getUserName());//user.getUsername()用户登录成功获得的信息
		   return new JsonResult("update ok");
	   }
	  
}
