package com.sid.domainy.web;



import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import com.sid.domainy.security.*;
import com.sid.domainy.dao.UserRepo;
import com.sid.domainy.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sid.domainy.metier.CategoryService;
import com.sid.domainy.metier.UserService;
import com.sid.domainy.model.LoginCredentials;

@Controller

public class CategoryMetier {
    @Autowired private CategoryService categoryService;
   

   
   @RequestMapping(value="/")
	 public String ConsulterList(Model model) {
	   Page<Categorie> categories=categoryService.consulterCategories();
		 model.addAttribute("listCategories", categories.getContent());
		 return "category";
	 
   
   }
	 
	   

}
