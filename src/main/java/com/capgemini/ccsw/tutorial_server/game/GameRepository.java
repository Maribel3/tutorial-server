package com.capgemini.ccsw.tutorial_server.game;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.tutorial_server.game.model.Game;
@Transactional
public interface GameRepository extends CrudRepository<Game, Long> {

	@Query("select g from Game g where (:title is null or g.title like '%'||:title||'%') and (:category is null or g.category.id = :category)")
    List<Game> find(@Param("title") String title, @Param("category") Long category);

	@Modifying
	 @Query("delete from Game g where category_id=:category")
	 void deleteByCategoryIdNativo(@Param("category") Long category);
	 
	
}
