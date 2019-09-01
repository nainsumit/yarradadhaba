package com.restaurant.user.dao;

import com.restaurant.user.bean.User;

public interface IUserDao
{
	public boolean userLogin(User user);
	
	public boolean registerUser(User user);

	public boolean checkUSerAlreadyExistInDatabase(User user);
}
