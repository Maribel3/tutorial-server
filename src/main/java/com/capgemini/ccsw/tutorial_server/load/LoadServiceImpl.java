package com.capgemini.ccsw.tutorial_server.load;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial_server.author.model.Author;
import com.capgemini.ccsw.tutorial_server.author.model.AuthorSearchDto;
import com.capgemini.ccsw.tutorial_server.category.model.Category;
import com.capgemini.ccsw.tutorial_server.category.model.CategoryDto;
import com.capgemini.ccsw.tutorial_server.client.ClientService;
import com.capgemini.ccsw.tutorial_server.game.GameService;
import com.capgemini.ccsw.tutorial_server.load.model.Load;
import com.capgemini.ccsw.tutorial_server.load.model.LoadDto;
import com.capgemini.ccsw.tutorial_server.load.model.LoadSearchDto;

@Transactional
@Service
public class LoadServiceImpl implements LoadService {

	@Autowired
	ClientService clientService;
	@Autowired
	LoadRepository loadRepository;

	@Autowired
	GameService gameService;

	public Page<Load> getLoad(int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return this.loadRepository.findAll(page);

	}

	@Override
	public Page<Load> findPage(LoadSearchDto dto) {
		return this.loadRepository.findSearchFilterPage(dto.getGameId(), dto.getClientId(), dto.getDate(),
				dto.getPageable());
	}

	public Load get(Long id) {

		return this.loadRepository.findById(id).orElse(null);
	}

	@Override
	public List<Load> findAll() {

		return (List<Load>) this.loadRepository.findAll();
	}

	@Override
	public void save(Long id, LoadDto dto) {
		Load load = null;

		if (id == null)
			load = new Load();
		else
			load = this.loadRepository.findById(id).orElse(null);

		BeanUtils.copyProperties(dto, load, "id", "game", "client");
		load.setClient(clientService.get(dto.getClient().getId()));
		load.setGame(gameService.get(dto.getGame().getId()));

		this.loadRepository.save(load);
	}

	@Override
	public void delete(Long id) {

		this.loadRepository.deleteById(id);

	}

	public void deleteGameLoad(Long game) {
		this.loadRepository.deleteGameLoad(game);

	}

	@Override
	public Integer validateLoan(Long game, String fecha) {
		return this.loadRepository.validateLoan(game, fecha);
	}

	@Override
	public Integer validateGameLoad(String fecha, Long client) {
		return this.loadRepository.validateGameLoad(client, fecha);
	}

	@Override
	public Integer comprobarClientePrestamo(Long client) {
		return this.loadRepository.comprobarClientePrestamo(client);
	}

	@Override
	public Integer comprobarJuegos(Long game, String fecha) {
		return this.loadRepository.comprobarJuegos(game, fecha);
	}

	@Override
	public Integer fechaInferior(Long client, String fecha) {
		return this.loadRepository.fechaInferior(client, fecha);
	}

	@Override
	public Integer validarDateReturn(Long client, String fecha) {
		return this.loadRepository.validarDateReturn(client, fecha);
	}

	@Override
	public Page<Load> findSearchFilterPage(Long game, Long client, String fecha, Pageable pageable) {
		return this.loadRepository.findSearchFilterPage(game, client, fecha, pageable);
	}

}
