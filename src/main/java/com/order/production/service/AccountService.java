package com.order.production.service;

import com.order.production.entities.AppRole;
import com.order.production.entities.AppUser;

public interface AccountService {
	
	void createUser(AppUser appUser);
	AppUser findUser(String username);
	AppRole findRole(String rolename);
	void createRole(AppRole appRole);
	void addRole(String username,String rolename);
	

}
