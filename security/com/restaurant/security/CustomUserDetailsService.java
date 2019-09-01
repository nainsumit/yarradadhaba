package com.restaurant.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.restaurant.security.user.MediUser;
import com.restaurant.security.user.UserProfile;

public class CustomUserDetailsService implements UserDetailsService
{

	/*@Autowired
	private SessionFactory sessionFactory;*/

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		MediUser mediUser = null;
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		if (!"".equals(username))
		{
			UserProfile userProfile = loadUserDetails(username);

			if (null != userProfile)
			{
				List<String> userRoles = userProfile.getUserRoles();

				if (null != userRoles && userRoles.size() > 0)
				{
					for (String userRole : userRoles)
					{
						authorities.add(new SimpleGrantedAuthority(userRole));
					}

					mediUser = new MediUser(username, userProfile.getPassword(), true, true, true, true, authorities,
							userProfile.getFirstName(), userProfile.getEmail(), userProfile.getLastName(),
							userProfile.getPhone(), userProfile.getAddress());

				}
				else
				{
					mediUser = new MediUser(username, "NA", true, true, true, true, authorities, null, null, null, null,
							null);
				}
			}
			else
			{
				mediUser = new MediUser(username, "NA", true, true, true, true, authorities, null, null, null, null,
						null);
			}
		}
		return mediUser;
	}

	private UserProfile loadUserDetails(String username)
	{
		return null;
	}

}