/*package com.example.logs;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.xml.DOMConfigurator;

public class LogHelper
{
	public final int DEBUG = Priority.DEBUG_INT / 10000;

	public final int INFO = Priority.INFO_INT / 10000;

	public final int WARN = Priority.WARN_INT / 10000;

	public final int ERROR = Priority.ERROR_INT / 10000;

	public final int FATAL = Priority.FATAL_INT / 10000;

	private static Properties prop = null;

	//private static String fileName = "/properties/log4j.properties"; 

	private static LogHelper logHelper;

	private static String localFilePath = "G:/log4j.xml";

	private static boolean log4jConfigured = false;

	static
	{
		synchronized (LogHelper.class)
		{
			try
			{
				configure();
			}
			catch (IOException ioExp)
			{
				ioExp.printStackTrace();
				Logger logger = Logger.getLogger(LogHelper.class.getName());
				logger.error("Error encountered while loading log4j.properties " + ioExp.getMessage());
			}
		}
	}

	public static synchronized LogHelper getInstance()
	{
		if (logHelper == null)
		{
			logHelper = new LogHelper();
		}
		return logHelper;
	}

	private Logger getLogger(String className)
	{
		if (null == className)
			className = LogHelper.class.getName();
		return Logger.getLogger(className);
	}

	public void addData(Object message)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).debug(
				prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + message);
	}

	public void addData(String className, Object message)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).debug(
				prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + message);
	}

	public void logData(Object data)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).debug(prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + data);
	}

	public void logData(String message, Object data)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		//                if (logger != null) { 
		//                        int priorityLevel = logger.getEffectiveLevel().toInt() / 10000; 
		//                        logData(priorityLevel, className, data); 
		//                } 

		getLogger(callerClassName).debug(
				prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " " + message + " :: " + data);

	}

	public void logData(int priority, Class callingClass, String method,Object data)
	{

		System.out.println("Class "+callingClass);
		System.out.println("Class "+callingClass.getEnclosingMethod());
		System.out.println("Class "+callingClass.getSimpleName());
		System.out.println("Class "+callingClass.getName());
		
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();
		
		int priorityLevel = getLogger(callerClassName).getEffectiveLevel().toInt() / 10000;

		if (!(data instanceof Throwable) && priorityLevel <= priority)
		{

			switch (priority)
			{
				case DEBUG:
					getLogger(callerClassName).debug(
							prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + data);
					break;
				case INFO:
					getLogger(callingClass.getSimpleName()).info(callingClass.getSimpleName()+" "+callingClass.getName()+ " "+method +" "+ data);
					break;
				case WARN:
					getLogger(callerClassName).info(
							prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + data);
					break;
				case ERROR:
					getLogger(callerClassName).error(
							prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + callingClass + " "
									+ data);
					break;
				case FATAL:
					getLogger(callerClassName).error(
							prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + callingClass + " "
									+ data);
					break;
				default:
					getLogger(callerClassName).info(
							prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + data);
			}
		}
		else if (data instanceof Throwable)
		{
			getLogger(callerClassName).error(prepareCallerInfoStr(callerClassName, methodName, lineNumber),
					(Throwable) data);
		}
		return;
	}

	private static void configure() throws IOException { 
	        if (prop == null) { 
	                prop = new Properties(); 
	                String filePath = System.getProperty("loggerPath"); 
	                if (filePath != null) 
	                        prop.load(new FileInputStream(filePath)); 
	                else 
	                        prop.load(LogHelper.class.getResourceAsStream(fileName)); 
	                PropertyConfigurator.configure(prop); 
	        } 
	}

	private static void configure() throws IOException
	{
		if (!log4jConfigured)
		{ //if (prop == null) { 
			//prop = new Properties(); 
			//String filePath = System.getProperty("loggerPath");     //log4j properties path 
			String filePath = "G:/log4j.xml";System.getProperty("LOG4J_FILE_PATH"); //log4j xml path 

			if (filePath != null)
			{
				//prop.load(new FileInputStream(filePath)); 
				DOMConfigurator.configure(filePath);
			}
			else
			{
				DOMConfigurator.configure(localFilePath);
				//prop.load(AppLog.class.getResourceAsStream(localFilePath)); 
			}
			//        PropertyConfigurator.configure(prop); 

			log4jConfigured = true;
		}
	}

	public void info(Object data)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).info(prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + data);
	}

	public void debug(Object data)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).debug(prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + data);
	}

	public void logError(String message, Object data)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).error(
				prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + message + " " + data);
	}

	public void logError(Throwable t)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).error(prepareCallerInfoStr(callerClassName, methodName, lineNumber), t);
	}

	public void logFatal(String message, Object data)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).fatal(
				prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + message + " " + data);
	}

	private String prepareCallerInfoStr(String className, String methodName, int lineNumber)
	{
		//            String str = String.valueOf(Thread.currentThread().getId ()) + " :: " + className + ":" + methodName + "[" + lineNumber + "]" ;
		String str = className + ":" + methodName + "[" + lineNumber + "]";
		return str;
	}

	//========================================================================== 
	//====THESE METHODS NEED TO BE DEPRECATED GRADUALLY .. 
	//========================================================================== 

	public void debug(boolean fileAppend, boolean stdoutAppend, Object logComment)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).debug(
				prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + logComment);
	}

	public void info(boolean fileAppend, boolean stdoutAppend, Object logComment)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).info(
				prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + logComment);
	}

	public void warn(boolean fileAppend, boolean stdoutAppend, Object logComment)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).info(
				prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + logComment);
	}

	public void error(boolean fileAppend, boolean stdoutAppend, Object logComment)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).error(
				prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + logComment);
	}

	public void fatal(boolean fileAppend, boolean stdoutAppend, Object logComment)
	{
		StackTraceElement myCaller = Thread.currentThread().getStackTrace()[3];
		String callerClassName = myCaller.getClassName();
		String methodName = myCaller.getMethodName();
		int lineNumber = myCaller.getLineNumber();

		getLogger(callerClassName).error(
				prepareCallerInfoStr(callerClassName, methodName, lineNumber) + " :: " + logComment);
	}

}
*/