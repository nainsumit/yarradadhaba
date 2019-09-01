package com.restaurant.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider
{
	private Log log = LogFactory.getLog(getClass());

	public CustomAuthenticationProvider()
	{
		log.info("CustomAuthenticationProvider / constuctor ");
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
		log.info("CustomAuthenticationProvider / authenticate ");
		Authentication auth = null;
		authentication.getDetails();
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		System.out.println("name "+name);
		System.out.println("password "+password);
		
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		/* grantedAuths.add(new GrantedAuthorityImpl("permitAll")); */
		
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

		if (name.equals("himanshu@gmail.com") && password.equals("123456"))
			auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
		else
			throw new BadCredentialsException("Wrong UserName or Password");
		return auth;
	}

	@Override
	public boolean supports(Class<?> authentication)
	{
		return true;
		// return
		// authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
