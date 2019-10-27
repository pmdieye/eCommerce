package com.order.production.service.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.order.production.entities.AppUser;
import com.order.production.service.AccountService;


@Service
public class UserDetailsImple  implements UserDetailsService{
	
	@Autowired
	private AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AppUser appUser = accountService.findUser(username);
		if (appUser == null) {
			throw new UsernameNotFoundException(username);
		}
		Collection<GrantedAuthority> authorities=new ArrayList<>();
		appUser.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		});
		
		return new User(appUser.getUserName(), appUser.getPassword(), authorities);
	}

}
