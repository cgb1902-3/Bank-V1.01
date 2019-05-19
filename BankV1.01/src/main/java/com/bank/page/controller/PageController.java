package com.bank.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("doIndex")
	public String doIndex(){
		return "index";
	}
<<<<<<< HEAD
	@RequestMapping("doUserMessage")
	public String doUserMessage() {
		return "usermessage";
=======
	@RequestMapping("doLoginUser")
	public String doLoginUser(){
		return "login_user";
	}
	@RequestMapping("doLoginManager")
	public String doLoginManager(){
		return "login_manager";
>>>>>>> 3809a7e4d4016876f998b51847539cd536d56b32
	}
}
