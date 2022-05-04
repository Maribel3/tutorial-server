package com.capgemini.ccsw.tutorial_server.category;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.tutorial_server.category.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

	
}
