package com.shops.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shops.beans.Role;
import com.shops.beans.User;
import com.shops.beans.UserShopDetail;
import com.shops.dao.RoleDao;
import com.shops.dao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	private UserDao userDao;
	private RoleDao roleDao;
	
	
	
	public UserDetailsServiceImpl(UserDao userDao, RoleDao roleDao) {
		super();
		this.userDao = userDao;
		this.roleDao = roleDao;
	}



	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userDao.findByEmail(email);
		List<Role> roles = this.roleDao.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("cannot find email: " + email);
		}
		return new UserShopDetail(user, roles);
	}

}
