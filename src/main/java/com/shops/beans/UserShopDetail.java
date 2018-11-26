package com.shops.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserShopDetail implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private List<Role> roles;
	
	
	public UserShopDetail(User user, List<Role> roles) {
		super();
		this.user = user;
		this.roles = roles;
	}
	
	
	public UserShopDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Role> getRole() {
		return roles;
	}


	public void setRole(List<Role> roles) {
		this.roles = roles;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		if(roles == null) {
			return Collections.emptyList();
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		roles.forEach(role->grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole())));
		return grantedAuthorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
