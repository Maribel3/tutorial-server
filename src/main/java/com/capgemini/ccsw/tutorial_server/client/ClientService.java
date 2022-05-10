package com.capgemini.ccsw.tutorial_server.client;

import java.util.List;

import com.capgemini.ccsw.tutorial_server.client.model.Client;
import com.capgemini.ccsw.tutorial_server.client.model.ClientDto;

public interface ClientService {

	List<Client> findAll();

	void save(Long id, ClientDto dto);

	boolean delete(Long id);

	Client get(Long id);

	Integer validarCliente(String name);
}
