package com.sid.domainy.entities;

import java.io.Serializable;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;


@Entity
@Data 
@DiscriminatorValue("client")
public class Client extends AppUser implements Serializable{

}
