package com.sid.domainy.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.domainy.dao.CategoryRepo;
import com.sid.domainy.entities.*;

@Service
@Transactional
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;

	
	public Categorie save(Categorie categorie) {
		return categoryRepo.save(categorie);
	}
	public Page<Categorie> consulterCategories() {
		 Page <Categorie>  pagecategories=categoryRepo.findAll(PageRequest.of(0, 4));
	
		 return pagecategories;
		 }
}
