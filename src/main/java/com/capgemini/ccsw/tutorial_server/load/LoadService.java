package com.capgemini.ccsw.tutorial_server.load;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.capgemini.ccsw.tutorial_server.category.model.CategoryDto;
import com.capgemini.ccsw.tutorial_server.load.model.Load;
import com.capgemini.ccsw.tutorial_server.load.model.LoadDto;

public interface LoadService {

	List<Load> findAll();
	
	
	void delete (Long id);
	
	List<Load> findClient(Long client);
	List <Load> findGame(Long game);
	List<Load> findGameClient(Long game, Long client);
	List<Load> findDate (
			String fecha);
	void save (Long id, LoadDto dto);
	List <Load> findSearchFilter(Long game,Long client, String fecha);
	//List <Load> mostrarNombre();
	void deleteGameLoad(Long game);
	
	
}
