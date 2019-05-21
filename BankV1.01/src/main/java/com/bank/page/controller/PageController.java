package com.bank.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
	@RequestMapping("doIndex")
	public String doIndex(){
		return "index";
	}
	@RequestMapping("doLoginUser")
	public String doLoginUser(){
		return "user/login_user";
	}
	@RequestMapping("doLoginManager")
	public String doLoginManager(){
		return "manager/log";
	}
	@RequestMapping("doUserMessage")
	public String doUserMessage() {
		return "user/usermessage";
	}
	@RequestMapping("doIndexManager")
	public String doIndexManager(){
		return "manager/index_manager";
	}
	@RequestMapping("doMainUI.do")
	public String doMainUI(){
		return "manager/main";
	}
	@RequestMapping("doUserAddUI.do")
	public String doUserAddUI(){
		return "manager/useradd";
	}
	@RequestMapping("doVipAddUI.do")
	public String doVipAddUI(){
		return "manager/vipadd";
	}
	@RequestMapping("doAddUI.do")
	public String doAddUI(){
		return "manager/vipadd2";
	}
}
