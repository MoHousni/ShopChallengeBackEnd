package com.shops.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shops.beans.User;

public interface UserDao extends JpaRepository<User, Long>{
	User findByEmail(String email);

}
