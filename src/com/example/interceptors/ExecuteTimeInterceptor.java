package com.example.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.generic.logger.LogHelper;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter
{
	
	LogHelper logHelper = LogHelper.getInstance();
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{

		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);

		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		long startTime = (Long) request.getAttribute("startTime");

		long endTime = System.currentTimeMillis();

		long executeTime = endTime - startTime;

		logHelper.logData(logHelper.INFO, this.getClass() , "postHandle" ,"Logs "+"[" + handler + "] executeTime : " + executeTime + "ms");
	}
}
