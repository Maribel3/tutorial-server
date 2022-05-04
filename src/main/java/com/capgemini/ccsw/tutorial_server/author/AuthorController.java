package com.capgemini.ccsw.tutorial_server.author;


import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.tutorial_server.author.model.Author;
import com.capgemini.ccsw.tutorial_server.author.model.AuthorDto;
import com.capgemini.ccsw.tutorial_server.author.model.AuthorSearchDto;
import com.capgemini.ccsw.tutorial_server.config.mapper.BeanMapper;



@RequestMapping(value = "/author")
@RestController
@CrossOrigin(origins = "*")

public class AuthorController{

  

	@Autowired
    AuthorService authorService;

    @Autowired
    BeanMapper beanMapper;
  
    //@PostMapping("/author/all")
   // @RequestMapping(path = { "", "/all" }, method = RequestMethod.GET)
   // public Page<Author> getAuthor(@RequestParam int pageSize, @RequestParam int pageNumber ){
   // public Page<AuthorDto> findPage(@RequestBody AuthorSearchDto dto) {
//Page<Author> result = this.authorService.findPage((dto));
     //   return this.beanMapper.mapPage(this.authorService.findPage(dto), AuthorDto.class);
    //	return this.authorService.getAuthor(pageNumber, pageSize);
    //}

    @RequestMapping(path = "/all", method = RequestMethod.POST)
    public Page<AuthorDto> findPage(@RequestBody AuthorSearchDto dto) {

        return this.beanMapper.mapPage(this.authorService.findPage(dto), AuthorDto.class);
    }
   
    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody AuthorDto data) {

        this.authorService.save(id, data);
    }

  
   
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {

        this.authorService.delete(id);
    }
 
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<AuthorDto> findAll() {

        List<Author> authors = this.authorService.findAll();

        return this.beanMapper.mapList(authors, AuthorDto.class);
    }
}