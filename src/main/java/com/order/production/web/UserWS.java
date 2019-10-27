package com.order.production.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.production.entities.AppUser;
import com.order.production.service.AccountService;

@RestController
@RequestMapping("api")
public class UserWS {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	public void  createuser(@RequestBody AppUser appUser) {
		accountService.createUser(appUser);
		
	}
	
	

}
