package com.restaurant.user.service;

import com.restaurant.user.bean.User;

public interface IUserService
{
	public boolean userLogin(String email , char[] password);
	public boolean registerUser(User user);
	public boolean validateUserDetailsBeforeRegistration();
}
