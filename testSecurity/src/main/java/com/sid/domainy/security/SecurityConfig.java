package com.sid.domainy.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sid.domainy.dao.UserRepo;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private UserRepo userRepo;
    @Autowired private JWTFilter filter;
    @Autowired private MyUserDetailsService uds;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
     http.csrf().disable()
          .httpBasic().disable()
          .cors()
          .and()
          .authorizeHttpRequests()
          .antMatchers("/api/auth/**").permitAll()
          .antMatchers("/api/user/**").hasRole("ADMIN")
          .antMatchers("/api/Category/**").hasRole("USER")
          .and()
      	.formLogin()
      	.and()
      	.logout()
      	.and()
      	.exceptionHandling().accessDeniedPage("/403")
      	;
      	http.csrf().disable();
      	http.headers().frameOptions().disable();

          http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
      	}

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}