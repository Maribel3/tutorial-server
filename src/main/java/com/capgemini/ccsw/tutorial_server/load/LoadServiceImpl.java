package com.capgemini.ccsw.tutorial_server.load;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial_server.category.model.Category;
import com.capgemini.ccsw.tutorial_server.category.model.CategoryDto;
import com.capgemini.ccsw.tutorial_server.client.ClientService;
import com.capgemini.ccsw.tutorial_server.game.GameService;
import com.capgemini.ccsw.tutorial_server.load.model.Load;
import com.capgemini.ccsw.tutorial_server.load.model.LoadDto;
@Transactional
@Service
public class LoadServiceImpl implements LoadService {


 @Autowired 
 ClientService clientService;
	  @Autowired
	  LoadRepository loadRepository;

	  @Autowired 
	  GameService gameService;
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
    @Override
	public List<Load> findGameClient(Long game, Long client) {
		
		return this.loadRepository.findGameClient(game,client);
	}


	@Override
	public List<Load> findDate( String fecha) {
		return this.loadRepository.findDate( fecha);
	}


	@Override
	public List<Load> findSearchFilter(Long game, Long client, String fecha) {
		return this.loadRepository.findSearchFilter(game, client, fecha);
	}


	@Override
	public List<Load> findClient(Long client) {
		return this.loadRepository.findClient(client);
	}


	@Override
	public List<Load> findGame(Long game) {
		return this.loadRepository.findGame(game);
	}

	public void deleteGameLoad(Long game) {
		this.loadRepository.deleteGameLoad(game);
		
	}
	
	
	//@Override
	//public List<Load> mostrarNombre() {
		// TODO Auto-generated method stub
		//return null;
	//}


	

	
}


