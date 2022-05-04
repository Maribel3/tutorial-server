package com.capgemini.ccsw.tutorial_server.client;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.tutorial_server.client.model.ClientDto;
import com.devonfw.module.beanmapping.common.api.BeanMapper;

@RequestMapping(value = "/client")
@RestController
@CrossOrigin(origins = "*")

public class ClientController {

	@Autowired
	  private ClientService clientService;

	  /**
	  * Método para recuperar todas las Category
	  * @return
	  */
	 @Autowired
	  BeanMapper beanMapper;
	 
	
	 
		@CrossOrigin(origins = "*")

	  @RequestMapping(path = "", method = RequestMethod.GET)
	  public List<ClientDto> findAll() {

		    return this.beanMapper.mapList(this.clientService.findAll(), ClientDto.class);
	  }

	  /**
	  * Método para crear o actualizar una Category
	  * @param dto
	  * @return
	  */
	  @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.POST)
	  public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody ClientDto dto) {

	    this.clientService.save(id, dto);
	  }

	  /**
	  * Método para borrar una Category
	  * @param id
	  *  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	  public void delete(@PathVariable("id") Long id) {

	    this.clientService.delete(id);
	  }
	  */
	 
	  @DeleteMapping(path ="/{id}")
	  public String deleteById(@PathVariable("id") Long id) {
		  boolean ok = this.clientService.delete(id);
		  
		  if (ok) {
			 return "Se eliminó el cliente con id " + id;
		  }
		  else {
			  return "No pudo eliminar el cliente con id " +id;
		  }
		  }
	 
	  @RequestMapping(path ="/validar{name}", method = RequestMethod.GET)
		 public Integer validarCliente(@RequestParam(value="name", required = false)String name){
			
		  return (Integer) this.clientService.validarCliente(name);
			
		 }
	}