package com.capgemini.ccsw.tutorial_server.author;
import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.ccsw.tutorial_server.author.model.Author;
import com.capgemini.ccsw.tutorial_server.author.model.AuthorDto;
import com.capgemini.ccsw.tutorial_server.author.model.AuthorSearchDto;


public interface AuthorService {

	List<Author> findAll();

	Author get(Long id);

	void save(Long id, AuthorDto data);

	void delete(Long id);

	Page<Author> findPage(AuthorSearchDto dto);
}