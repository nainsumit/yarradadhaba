package com.restaurant.security.user;

import java.util.List;

public class UserProfile
{
	String password;

	String firstName;

	String lastName;

	String email;

	String phone;

	String[] address;
	
	List<String> userRoles;

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String[] getAddress()
	{
		return address;
	}

	public void setAddress(String[] address)
	{
		this.address = address;
	}

	public List<String> getUserRoles()
	{
		return userRoles;
	}

	public void setUserRoles(List<String> userRoles)
	{
		this.userRoles = userRoles;
	}
}
