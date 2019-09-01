package com.restaurant.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.user.bean.User;
import com.restaurant.user.dao.IUserDao;

@Service("userService")
public class UserService implements IUserService
{
	@Autowired(required=true)
	IUserDao userDao;
	
	@Override
	public boolean userLogin(String email , char[] password)
	{
		User user = new User();
		user.setEmail(email);
		user.setPassword(new String(password));
		
		return userDao.userLogin(user);
	}

	@Override
	public boolean registerUser(User user)
	{
		return userDao.registerUser(user);
	}
	
	@Override
	public boolean validateUserDetailsBeforeRegistration()
	{
		return false;
	}
}
