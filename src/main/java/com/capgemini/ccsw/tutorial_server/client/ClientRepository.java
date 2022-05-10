package com.capgemini.ccsw.tutorial_server.client;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.ccsw.tutorial_server.client.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

	@Query("select c from Client c where c.name like %:name%")
	List<Client> searchName(@Param("name") String name);

	@Query("select count(c.id) from Client c where c.name= :name ")
	Integer validarCliente(@Param("name") String name);
}
