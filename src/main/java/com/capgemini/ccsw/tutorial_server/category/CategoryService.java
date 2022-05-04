package com.capgemini.ccsw.tutorial_server.category;

import java.util.List;

import com.capgemini.ccsw.tutorial_server.category.model.Category;
import com.capgemini.ccsw.tutorial_server.category.model.CategoryDto;

public interface CategoryService {

	/**
	    * Recupera una {@link com.capgemini.ccsw.tutorial.category.model.Category} a partir de su ID
	    * @param id
	    * @return
	    */
	    Category get(Long id);
	List<Category> findAll();
	void save (Long id, CategoryDto dto);
	void delete (Long id);
}
