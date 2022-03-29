package com.sid.domainy.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.sid.domainy.entities.AppUser;



@Entity
@DiscriminatorValue("admin")
public class Admin extends AppUser implements Serializable {

}
