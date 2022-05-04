package com.capgemini.ccsw.tutorial_server.game;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.capgemini.ccsw.tutorial_server.game.model.Game;
import com.capgemini.ccsw.tutorial_server.game.model.GameDto;

/**
* @author ccsw
*/
public interface GameService {

    /**
    * Recupera los juegos filtrando opcionalmente por título y/o categoría
    * @param title
    * @param idCategory
    * @return
    */
    List<Game> find(String title, Long idCategory);

    /**
    * Guarda o modifica un juego, dependiendo de si el id está o no informado
    * @param id
    * @param dto
    */
    void save(Long id, GameDto dto);
    void deleteByCategoryIdNativo(Long idCategory) throws Exception;
	void delete (Long idCategory);

	Game get(Long id);

	
	

}