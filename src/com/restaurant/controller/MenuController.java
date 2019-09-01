package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restaurant.menu.service.IMenuService;
import com.restaurant.response.bean.ResponseBean;
import com.restaurant.utility.ResponseHandlerUtility;

@Controller
@RequestMapping(value = "/menu")
public class MenuController
{
	@Autowired
	@Qualifier("menuService")
	IMenuService menuService;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/download", method = RequestMethod.GET)
	@ResponseBody 
	public ResponseBean menu()
	{		
		try
		{	
			return menuService.fetchMenu();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			
			return ResponseHandlerUtility.createErrorResponseBean();
		}
	}
}
