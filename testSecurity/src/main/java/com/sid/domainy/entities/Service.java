package com.sid.domainy.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Service {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String image;
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<Provider> providers=new ArrayList<>();;
	@ManyToOne
	private Categorie categorie;
	
}
