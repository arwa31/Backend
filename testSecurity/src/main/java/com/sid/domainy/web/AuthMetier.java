package com.sid.domainy.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sid.domainy.dao.UserRepo;
import com.sid.domainy.metier.UserService;
import com.sid.domainy.model.LoginCredentials;
import com.sid.domainy.security.JWTUtil;
import com.sid.domainy.entities.*;

import java.util.Collections;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/api/auth")
public class AuthMetier {

    @Autowired private UserService userService;
    @Autowired private JWTUtil jwtUtil;
    @Autowired private AuthenticationManager authManager;
    @Autowired private PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public void registerHandler(@RequestBody Admin client){
        String encodedPass = passwordEncoder.encode(client.getPassword());
        client.setPassword(encodedPass);
        client =  (Admin) userService.save(client);
    }
 @PostMapping("/update")
    public void updateHandler(@RequestBody AppUser user){
    	   AppUser appuser= userService.findByUsername(user.getUsername());
        if(appuser.getType().equals("client")) {
        	appuser.setPassword(passwordEncoder.encode(user.getPassword()));
        	userService.save((Client)appuser);
        	
        }else if(appuser.getType().equals("provider")){
        	appuser.setPassword(passwordEncoder.encode(user.getPassword()));
        	userService.save((Provider )appuser);
        }
    }
    @PostMapping("/info")
    public AppUser getInfo(@RequestBody AppUser user){
        AppUser appuser= userService.findByUsername(user.getUsername());
        return appuser;   
        }
    @PostMapping("/registerCli")
    public void registerHandler(@RequestBody Client client){
        String encodedPass = passwordEncoder.encode(client.getPassword());
        client.setPassword(encodedPass);
        client = (Client) userService.save(client);
        
    }
    @PostMapping("/registerPro")
    public void registerHandler(@RequestBody Provider provider){
        String encodedPass = passwordEncoder.encode(provider.getPassword());
        provider.setPassword(encodedPass);
        provider = (Provider)userService.save(provider);        
    }
   
  
    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody LoginCredentials body){
        try {
        	UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());
            authManager.authenticate(authInputToken);
            String token = jwtUtil.generateToken(body.getUsername());
            return Collections.singletonMap("jwt-token", token);
        }catch (AuthenticationException authExc){
            throw new RuntimeException("Invalid Login Credentials");
        }
    }


}