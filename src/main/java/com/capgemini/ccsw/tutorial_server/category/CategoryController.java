package com.capgemini.ccsw.tutorial_server.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.tutorial_server.category.model.CategoryDto;
import com.capgemini.ccsw.tutorial_server.game.GameService;
import com.capgemini.ccsw.tutorial_server.load.LoadService;
import com.devonfw.module.beanmapping.common.api.BeanMapper;

@RequestMapping(value = "/category")
@RestController
@CrossOrigin("*")

public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	LoadService loadService;

	@Autowired
	GameService gameService;

	@Autowired
	BeanMapper beanMapper;

	@CrossOrigin(origins = "*")

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<CategoryDto> findAll() {

		return this.beanMapper.mapList(this.categoryService.findAll(), CategoryDto.class);
	}

	@RequestMapping(path = { "", "/{id}" }, method = RequestMethod.POST)

	public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody CategoryDto dto) {
		this.categoryService.save(id, dto);

	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		Long game = id;
		Long category = id;

		try {
			this.loadService.deleteGameLoad(game);
			this.gameService.deleteByCategoryIdNativo(category);
			this.categoryService.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
