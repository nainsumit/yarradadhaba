package com.restaurant.security.user;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MediUser extends User
{

	private static final long serialVersionUID = -3531439484732724601L;

	private final String firstName;

	private final String email;

	private final String lastName;

	private final String phNumber;

	private final String[] address;

	public MediUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, List<SimpleGrantedAuthority> authorities, String firstName,
			String email, String lastName, String phNumber, String[] address)
	{

		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

		this.firstName = firstName;
		this.email = email;
		this.lastName = lastName;
		this.phNumber = phNumber;
		this.address = address;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getEmail()
	{
		return email;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getPhNumber()
	{
		return phNumber;
	}

	public String[] getAddress()
	{
		return address;
	}

}