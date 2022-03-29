package com.sid.domainy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sid.domainy.entities.*;
@RepositoryRestResource
public interface UserRepo extends JpaRepository<AppUser,Long>{
public AppUser findByUsername(String username);
}
