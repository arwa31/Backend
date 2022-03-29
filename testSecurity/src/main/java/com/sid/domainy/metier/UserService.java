package com.sid.domainy.metier;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.domainy.dao.UserRepo;
import com.sid.domainy.entities.*;
@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepo userRepository;
	@Bean
	public PasswordEncoder passwordEncoder()
	{
	    return new BCryptPasswordEncoder();
	}
	
	
	public AppUser findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public AppUser save(AppUser appUser) {
				return userRepository.save(appUser);
			}
	public String deleteUser(long id) {		
		userRepository.deleteById(id);
			return "User removed !!"+id;
		}
	public List<AppUser> getUsers() {
		
		return userRepository.findAll();
	}
	public AppUser getUserById(long id) {
		
		return userRepository.findById(id).orElse(null);
	}
}
