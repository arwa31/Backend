package com.sid.domainy.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.domainy.metier.UserService;
import com.sid.domainy.entities.*;



@RestController
@RequestMapping("/api/user")
public class UserMetier {

    @Autowired private UserService userService;

    @GetMapping("/info")
    public AppUser getInfo(@RequestBody AppUser user){
        
        return userService.findByUsername(user.getUsername());   
        }}