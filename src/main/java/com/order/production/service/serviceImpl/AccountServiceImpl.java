package com.order.production.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order.production.entities.AppRole;
import com.order.production.entities.AppUser;
import com.order.production.repository.AppRoleRepository;
import com.order.production.repository.AppUserRepository;
import com.order.production.service.AccountService;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private AppRoleRepository appRoleRepository;
	@Autowired
	private AccountService accountService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void createUser(AppUser appUser) {
		// TODO Auto-generated method stub
		String hashcode= bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(hashcode);
		appUserRepository.save(appUser);
	}

	@Override
	public AppUser findUser(String username) {
		// TODO Auto-generated method stub
		return appUserRepository.findAppUserByUserName(username);
	}

	@Override
	public AppRole findRole(String rolename) {
		// TODO Auto-generated method stub
		return appRoleRepository.findAppRoleByRoleName(rolename);
	}

	@Override
	public void createRole(AppRole appRole) {
		// TODO Auto-generated method stub
		appRoleRepository.save(appRole);
		
	}

	@Override
	public void addRole(String username,String rolename) {
		// TODO Auto-generated method stub
		AppUser appUser= appUserRepository.findAppUserByUserName(username);
		AppRole appRole= appRoleRepository.findAppRoleByRoleName(rolename);
		appUser.getRoles().add(appRole);

	}

}
