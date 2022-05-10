package com.capgemini.ccsw.tutorial_server.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial_server.client.model.Client;
import com.capgemini.ccsw.tutorial_server.client.model.ClientDto;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientRepository clientRepository;

	public Client get(Long id) {

		return this.clientRepository.findById(id).orElse(null);
	}

	@Override
	public List<Client> findAll() {

		return (List<Client>) this.clientRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(Long id, ClientDto dto) {

		Client client = null;

		if (id == null)
			client = new Client();
		else
			client = this.clientRepository.findById(id).orElse(null);

		client.setName(dto.getName());

		this.clientRepository.save(client);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return
	 */

	@SuppressWarnings("unlikely-arg-type")
	public boolean validateName(String name) {
		if (clientRepository.searchName(name).equals(name)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(Long id) {

		try {
			clientRepository.deleteById(id);
			return true;

		} catch (Exception err) {
			return false;
		}
	}

	public Integer validarCliente(String name) {
		return this.clientRepository.validarCliente(name);
	}

}