package com.capgemini.ccsw.tutorial_server.load;

import java.sql.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.ccsw.tutorial_server.load.model.Load;
import com.capgemini.ccsw.tutorial_server.load.model.LoadDto;
@Transactional
public interface LoadRepository extends CrudRepository<Load, Long>{

	
	@Query("select l from Load l where game_id= :game and :fecha between date_loan and date_return")
	List <Load> findGameDate(@Param("game") Long game, @Param("fecha") String fecha);
	
	@Query("select l from Load l where client_id= :client and :fecha between date_loan and date_return")
	List <Load> findClientDate(@Param("client") Long client, @Param("fecha") String fecha);
	
	 @Query("select l from Load l where (:game is null or l.game.id = :game) and (:client is null or l.client.id = :client)")
    List<Load> findGameClient(@Param("game") Long game, @Param("client") Long client);

	 @Query("select l from Load l where game_id = :game")
	 List <Load> findGame(Long game);
	
	@Query("select l from Load l where client_id = :client")
	List<Load> findClient(Long client);

	
	@Query("select l from Load l where ?1 between date_loan and date_return")
	List<Load> findDate (
			String fecha);

	@Query("select l from Load l where (:game is null or l.game.id = :game) "
			+ "and (:client is null or l.client.id = :client) and  :fecha between date_loan and date_return")
	List <Load> findSearchFilter(@Param("game") Long game,@Param("client") Long client, @Param ("fecha")String fecha);

	
	 @Modifying
	 @Query("delete from Load l where game_id =:game")
	 void deleteGameLoad(@Param("game")Long game);
	 
	
	 Page<Load> findAll(Pageable pageable);
	 

	 @Query("select count(l) from Load l where l.game.id= :game and :fecha between date_loan and date_return ")
	 Integer validateLoan (@Param("game") Long game, @Param("fecha") String fecha);

	 
	 @Query("select l from Load l where l.client.id= :client and :fecha between date_loan and date_return")
	 List <Load> findSearchClientDate(@Param("client") Long client,@Param("fecha") String fecha);
	 
	 @Query("select count(l) from Load l where l.client.id = :client and :fecha between date_loan and date_return")
	 Integer validateGameLoad (@Param("client") Long client, @Param("fecha") String fecha);
	 
	 @Query("select count(l) from Load l where l.client.id= :client and :fecha > date_return")
	 Integer validarDateReturn(@Param("client") Long client, @Param("fecha") String fecha);
	 
	 @Query("select count(l) from Load l where l.client.id= :client")
	 Integer comprobarClientePrestamo(@Param("client")Long client);
	 
	 
	 @Query("select count(l) from Load l where l.client.id= :client and :fecha between date_loan and date_return ")
	 Integer fechaInferior(@Param("client") Long client, @Param("fecha") String fecha);
	 
     @Query("select count(l) from Load l where l.game.id= :game and :fecha between date_loan and (date_loan+14)")
     Integer comprobarJuegos (@Param("game") Long game, @Param("fecha") String fecha);
}