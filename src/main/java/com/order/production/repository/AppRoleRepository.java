package com.order.production.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.production.entities.AppRole;

public interface AppRoleRepository  extends JpaRepository<AppRole, Long>{
	 public  AppRole findAppRoleByRoleName(String rolename);
}
