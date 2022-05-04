package com.capgemini.ccsw.tutorial_server.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial_server.category.model.Category;
import com.capgemini.ccsw.tutorial_server.category.model.CategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService{

	 /**
	    * {@inheritDoc}
	    */
	    @Override
	    public Category get(Long id) {

	        return this.categoryRepository.findById(id).orElse(null);
	    }
	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public List<Category> findAll() {
	    return (List<Category>) this.categoryRepository.findAll();

	}

	@Override
	public void save(Long id, CategoryDto dto) {
		Category categoria = null;

	    if (id == null)
	      categoria = new Category();
	    else
            categoria = this.get(id);

	    categoria.setName(dto.getName());

	    this.categoryRepository.save(categoria);
	  }
	@Override
	public void delete(Long id) {
		 this.categoryRepository.deleteById(id);
		
	}

}
