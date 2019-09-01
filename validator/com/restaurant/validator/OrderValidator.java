package com.restaurant.validator;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.restaurant.order.bean.Orders;
import com.restaurant.user.bean.User;
import com.restaurant.utility.ValidationUtil;

public class OrderValidator implements Validator
{
	private Resource location;

	@Required
	public void setLocation(Resource location)
	{
		this.location = location;
	}

	@Override
	public boolean supports(Class<?> cls)
	{
		return Orders.class.equals(cls);
	}

	@Override
	public void validate(Object ob, Errors err)
	{
		Properties props = null;
		try
		{
			props = PropertiesLoaderUtils.loadProperties(location);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		ValidationUtils.rejectIfEmpty(err, "name", "errormsg.name", props.getProperty("errormsg.emptyName"));
		ValidationUtils.rejectIfEmpty(err, "email", "errormsg.email", props.getProperty("errormsg.emptyEmail"));
		ValidationUtils.rejectIfEmpty(err, "phone", "errormsg.phone", props.getProperty("errormsg.emptyPhone"));
		ValidationUtils.rejectIfEmpty(err, "username", "errormsg.username",props.getProperty("errormsg.emptyUsername"));
		ValidationUtils.rejectIfEmpty(err, "password", "errormsg.password",props.getProperty("errormsg.emptyPassword"));

		User user = (User) ob;
		if (ValidationUtil.validateEmail(user.getEmail()))
		{
			err.rejectValue("email", "errormsg.email", props.getProperty("errormsg.email"));
		}
	}

}
