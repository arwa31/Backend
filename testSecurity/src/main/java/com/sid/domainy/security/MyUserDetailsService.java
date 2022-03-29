package com.sid.domainy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sid.domainy.dao.UserRepo;
import com.sid.domainy.entities.*;

import java.util.Collections;
import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser userRes = userRepo.findByUsername(username);
        if(userRes.equals(null))
            {throw new UsernameNotFoundException("Could not findUser with username = " + username);}
        else if(userRes.getType().equals("admin")) {
        	return new org.springframework.security.core.userdetails.User(
                    username,
                    userRes.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }else {
        	return new org.springframework.security.core.userdetails.User(
                    username,
                    userRes.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        }
        		
        /*return new org.springframework.security.core.userdetails.User(
                username,
                userRes.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));*/
    }
}