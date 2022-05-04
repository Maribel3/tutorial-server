package com.capgemini.ccsw.tutorial_server.load;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.capgemini.ccsw.tutorial_server.game.model.Game;
import com.capgemini.ccsw.tutorial_server.load.model.Load;
import com.capgemini.ccsw.tutorial_server.load.model.LoadDto;
import com.devonfw.module.beanmapping.common.api.BeanMapper;

@RequestMapping(value="/load")
@RestController
@CrossOrigin(origins = "*")
public class LoadController {

	@Autowired
	private LoadService loadService;
	
	@Autowired
	BeanMapper beanMapper;
	
	  @RequestMapping(path = "", method = RequestMethod.GET)
	  public List<LoadDto> findAll() {

		    return this.beanMapper.mapList(this.loadService.findAll(), LoadDto.class);
		    
	  }

	  @RequestMapping(path = "/Search", method = RequestMethod.GET)
	  public List<LoadDto> findGameClient(@RequestParam(value="game_id", required = false)Long game,
	  @RequestParam(value="client_id", required =false)Long client){
	  
	        List<Load> loads = loadService.findGameClient(game, client);

	        return this.beanMapper.mapList(loads, LoadDto.class);

	    		
	  }
	   @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
	  public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody LoadDto dto) {

	    this.loadService.save(id, dto);
	  }

	  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	  public void delete(@PathVariable("id") Long id) {

	    this.loadService.delete(id);
	  }
	 @ResponseBody
	@RequestMapping(path = "/searchDate", method = RequestMethod.GET)
	public List<LoadDto> findDate (
		//@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateLoan,
			//@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateReturn, 
			//@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@PathVariable(required = false)String fecha){
		 
		 List<Load> loads = loadService.findDate(fecha);
		 return this.beanMapper.mapList(loads, LoadDto.class);

}
	 
	 @RequestMapping(path="/searchAll", method = RequestMethod.GET)
	 public List <LoadDto> findSearchFilter(@RequestParam(value="game_id", required = false)Long game,
	  @RequestParam(value="client_id", required =false)Long client, @RequestParam(value="fecha",required = false) String fecha){
		 List <Load> loads = loadService.findSearchFilter(game, client, fecha);
		 return this.beanMapper.mapList(loads, LoadDto.class);
		 
	 }
	 
	 @RequestMapping(path ="/client", method = RequestMethod.GET)
	 public List<LoadDto> findClient(@RequestParam(value="client_id", required = false)Long client){
		 List<Load> loads = loadService.findClient(client);
		 return this.beanMapper.mapList(loads, LoadDto.class);
	 }
	 @RequestMapping(path ="/game", method = RequestMethod.GET)
	 public List<LoadDto> findGame(@RequestParam(value="game_id", required = false)Long game){
		 List<Load> loads = loadService.findGame(game);
		 return this.beanMapper.mapList(loads, LoadDto.class);
	 }
	
	 
}
