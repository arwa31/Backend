package com.sid.domainy.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.criteria.Fetch;

import com.sid.domainy.entities.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("provider")
public class Provider  extends AppUser implements Serializable{
	private String descrip;
	private long rateNbr;
	private long signalNbr;
	@OneToMany
	@JoinTable(name="provider_images")
	private Collection<ImageServ> Images=new ArrayList<>();
	@ManyToMany(mappedBy="providers",fetch=FetchType.EAGER)
	private Collection<Service> services=new ArrayList<>();


}
