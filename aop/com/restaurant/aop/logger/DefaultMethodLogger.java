package com.restaurant.aop.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.generic.logger.LogHelper;
import com.restaurant.menu.dao.MenuDao;
import com.restaurant.utility.CoreConstants;

@Component
@Aspect
public class DefaultMethodLogger
{
	private LogHelper logHelper = LogHelper.getInstance();
	
	@Before("within(com.restaurant..*)")
	public void logBefore(JoinPoint joinPoint)
	{
		logHelper.logData(logHelper.DEBUG, MenuDao.class, joinPoint.getSignature().getName(), CoreConstants.STARTS);
		
		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@AfterReturning(pointcut = "within(com.restaurant..*)", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result)
	{
		logHelper.logData(logHelper.DEBUG, MenuDao.class, joinPoint.getSignature().getName(), CoreConstants.ENDS);
		
		System.out.println("logAfterReturning() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");
	}

	@AfterThrowing(pointcut = "within(com.restaurant..*)", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error)
	{
		System.out.println("logAfterThrowing() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}
}
