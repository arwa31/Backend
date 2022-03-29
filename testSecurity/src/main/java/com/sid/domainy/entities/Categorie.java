package com.sid.domainy.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.sid.domainy.entities.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Categorie {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String image;
	@OneToMany(mappedBy="categorie")
	private Collection<Service>services;
	
}
