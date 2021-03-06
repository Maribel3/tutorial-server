package com.capgemini.ccsw.tutorial_server.load;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.tutorial_server.author.model.AuthorDto;
import com.capgemini.ccsw.tutorial_server.author.model.AuthorSearchDto;
import com.capgemini.ccsw.tutorial_server.game.model.Game;
import com.capgemini.ccsw.tutorial_server.load.model.Load;
import com.capgemini.ccsw.tutorial_server.load.model.LoadDto;
import com.capgemini.ccsw.tutorial_server.load.model.LoadSearchDto;
import com.capgemini.ccsw.tutorial_server.config.mapper.BeanMapper;

@RequestMapping(value = "/load")
@RestController
@CrossOrigin(origins = "*")
public class LoadController {

	@Autowired
	private LoadService loadService;

	@Autowired
	BeanMapper beanMapper;

	@RequestMapping(path = "", method = RequestMethod.POST)
	public Page<LoadDto> findPage(@RequestBody LoadSearchDto dto) {

		return this.beanMapper.mapPage(this.loadService.findPage(dto), LoadDto.class);
	}

	@RequestMapping(path = "/findSearchFilterPage", method = RequestMethod.POST)
	public Page<LoadDto> findSearchFilterPage(@RequestParam(value = "game", required = false) Long game,
			@RequestParam(value = "client", required = false) Long client,
			@RequestParam(value = "fecha", required = false) String fecha, @RequestBody LoadSearchDto dto) {
		return this.beanMapper.mapPage(this.loadService.findSearchFilterPage(game, client, fecha, dto.getPageable()),
				LoadDto.class);
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<LoadDto> findAll() {

		return this.beanMapper.mapList(this.loadService.findAll(), LoadDto.class);

	}

	@RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
	public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody LoadDto dto) {

		this.loadService.save(id, dto);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {

		this.loadService.delete(id);
	}

	@RequestMapping(path = "/validateLoan", method = RequestMethod.GET)
	public Integer validateLoan(@RequestParam(value = "game", required = false) Long game,
			@RequestParam(value = "fecha", required = false) String fecha) {

		return (Integer) this.loadService.validateLoan(game, fecha);

	}

	@RequestMapping(path = "/validateGameLoad", method = RequestMethod.GET)
	public Integer validateGameLoad(@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "client_id", required = false) Long client) {

		return (Integer) this.loadService.validateGameLoad(fecha, client);

	}

	@RequestMapping(path = "/comprobarClientePrestamo", method = RequestMethod.GET)
	public Integer comprobarClientePrestamo(@RequestParam(value = "client_id", required = false) Long client) {

		return (Integer) this.loadService.comprobarClientePrestamo(client);

	}

	@RequestMapping(path = "/comprobarJuegos", method = RequestMethod.GET)
	public Integer comprobarJuegos(@RequestParam(value = "game", required = false) Long game,
			@RequestParam(value = "fecha") String fecha) {

		return (Integer) this.loadService.comprobarJuegos(game, fecha);

	}

	@RequestMapping(path = "/fechaInferior", method = RequestMethod.GET)
	public Integer fechaInferior(@RequestParam(value = "client", required = false) Long client,
			@RequestParam(value = "fecha") String fecha) {

		return (Integer) this.loadService.fechaInferior(client, fecha);

	}

	@RequestMapping(path = "/validarDateReturn", method = RequestMethod.GET)
	public Integer validarDateReturn(@RequestParam(value = "client", required = false) Long client,
			@RequestParam(value = "fecha") String fecha) {

		return (Integer) this.loadService.validarDateReturn(client, fecha);

	}

}
