package com.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepositry userRepositry;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userRepositry.findByUserName(username);
		if(user ==null) {
			throw new UsernameNotFoundException("User name "+username+"not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUser_name(), user.getPassword(), getGrantedAuthority(user));
	}
	
	private Collection<GrantedAuthority> getGrantedAuthority(User user){
		Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();
		if(user.getRole().getName().equals("admin")){
			grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		return grantedAuthority;
		
	}

}
