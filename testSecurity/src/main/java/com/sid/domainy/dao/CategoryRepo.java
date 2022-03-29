package com.sid.domainy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.domainy.entities.*;
@RepositoryRestResource
public interface CategoryRepo extends JpaRepository<Categorie,Long>{

}