package com.capgemini.ccsw.tutorial_server.game;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial_server.author.AuthorService;
import com.capgemini.ccsw.tutorial_server.category.CategoryService;
import com.capgemini.ccsw.tutorial_server.game.model.Game;
import com.capgemini.ccsw.tutorial_server.game.model.GameDto;
import com.capgemini.ccsw.tutorial_server.load.LoadService;

@Service
@Transactional
public class GameServiceImpl implements GameService {

	@Autowired
	GameRepository gameRepository;

	@Autowired
	AuthorService authorService;

	@Autowired
	LoadService loadService;
	@Autowired
	CategoryService categoryService;

	@Override
	public List<Game> find(String title, Long category) {

		return this.gameRepository.find(title, category);
	}

	@Override
	public void save(Long id, GameDto dto) {

		Game game = null;

		if (id == null)
			game = new Game();
		else
			game = this.gameRepository.findById(id).orElse(null);

		BeanUtils.copyProperties(dto, game, "id", "author", "category");

		game.setAuthor(authorService.get(dto.getAuthor().getId()));
		game.setCategory(categoryService.get(dto.getCategory().getId()));
		this.gameRepository.save(game);
	}

	@Override
	public void deleteByCategoryIdNativo(Long idCategory) {

		gameRepository.deleteByCategoryIdNativo(idCategory);

	}

	@Override
	public void delete(Long id) {
		this.gameRepository.deleteById(id);

	}

	@Override
	public Game get(Long id) {
		return this.gameRepository.findById(id).orElse(null);
	}

}