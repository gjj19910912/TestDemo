package com.bmtech.pushmessage.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bmtech.pushmessage.service.UserService;
import com.bmtech.pushmessage.utils.JSONUtils;

@Controller
@RequestMapping("/user")
public class TestContorller {

	@Autowired
	public UserService userService;
	
	@RequestMapping("/getUserList")
	public @ResponseBody String getUserList(){
		String result = JSONUtils.returnJSONMessageFromList(userService.getUserList(0, 0));
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("/getChinaChar")
	public @ResponseBody String getChinaChar(@RequestParam String username,@RequestParam String password){
		if("ÖÜ·å".equals(username) && "yi".equals(password)){
			return "ÕýÈ·";
		}
		return "´íÎó";
	}
	
}


