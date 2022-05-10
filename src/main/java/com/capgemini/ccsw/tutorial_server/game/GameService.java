package com.capgemini.ccsw.tutorial_server.game;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.capgemini.ccsw.tutorial_server.game.model.Game;
import com.capgemini.ccsw.tutorial_server.game.model.GameDto;

public interface GameService {

	List<Game> find(String title, Long idCategory);

	void save(Long id, GameDto dto);

	void deleteByCategoryIdNativo(Long idCategory) throws Exception;

	void delete(Long idCategory);

	Game get(Long id);

}