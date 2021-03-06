package com.capgemini.ccsw.tutorial_server.author;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ccsw.tutorial_server.author.model.Author;



@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	Page<Author> findAll(Pageable page);


   

}