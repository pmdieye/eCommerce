package com.order.production.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.production.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findAppUserByUserName(String username);
}
