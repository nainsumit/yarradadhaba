package com.restaurant.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class LoginController
{
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody String login()
	{		
		/*LoginResponse response = new LoginResponse();
		response.setStaus("true");
		response.setMessage("Login Successful");*/
		
		return "{ \"message\":\"success\" }";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public @ResponseBody String logout(HttpSession session)
	{		
		if(session != null)
			session.invalidate();
		
		return "{ \"message\":\"success\" }";
	}
}