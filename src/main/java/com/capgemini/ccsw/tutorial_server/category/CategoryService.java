package com.capgemini.ccsw.tutorial_server.category;

import java.util.List;

import com.capgemini.ccsw.tutorial_server.category.model.Category;
import com.capgemini.ccsw.tutorial_server.category.model.CategoryDto;

public interface CategoryService {

	Category get(Long id);

	List<Category> findAll();

	void save(Long id, CategoryDto dto);

	void delete(Long id);
}
