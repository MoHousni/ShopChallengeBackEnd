package com.shops.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shops.beans.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
	List<Role> findByEmail(String email);
}
