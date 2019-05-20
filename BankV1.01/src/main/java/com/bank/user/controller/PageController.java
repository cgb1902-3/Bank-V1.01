package com.bank.user.controller;

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
		return "login_user";
	}
	@RequestMapping("doLoginManager")
	public String doLoginManager(){
		return "login_manager";
	}
	@RequestMapping("doUserMessage")
	public String doUserMessage() {
		return "usermessage";
	}
	
	

}
