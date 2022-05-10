package com.capgemini.ccsw.tutorial_server.load;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.capgemini.ccsw.tutorial_server.author.model.Author;
import com.capgemini.ccsw.tutorial_server.author.model.AuthorSearchDto;
import com.capgemini.ccsw.tutorial_server.category.model.CategoryDto;
import com.capgemini.ccsw.tutorial_server.load.model.Load;
import com.capgemini.ccsw.tutorial_server.load.model.LoadDto;
import com.capgemini.ccsw.tutorial_server.load.model.LoadSearchDto;

public interface LoadService {

	List<Load> findAll();

	void delete(Long id);

	void save(Long id, LoadDto dto);

	void deleteGameLoad(Long game);

	Page<Load> findPage(LoadSearchDto dto);

	Integer validateLoan(Long game, String fecha);

	Integer validateGameLoad(String fecha, Long client);

	Integer comprobarClientePrestamo(Long client);

	Integer comprobarJuegos(Long game, String fecha);

	Integer fechaInferior(Long client, String fecha);

	Integer validarDateReturn(Long client, String fecha);

	Page<Load> findSearchFilterPage(Long game, Long client, String fecha, Pageable pageable);

}
