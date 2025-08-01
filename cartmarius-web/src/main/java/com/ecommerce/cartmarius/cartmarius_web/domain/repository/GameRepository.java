package com.ecommerce.cartmarius.cartmarius_web.domain.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.cartmarius.cartmarius_web.domain.model.Game;

public interface GameRepository extends CrudRepository<Game,Integer>{

    @Query("SELECT g FROM Game g WHERE g.name = :name")
    Optional<Game> buscarPorNombre(@Param("name") String name);

    @Query("SELECT g FROM Game g WHERE g.gameId = :gameId")
    Optional<Game> findGameById(@Param("gameId") Integer gameId);

    @Query(value = """
    select 
      g.game_id as game_id,
      g.name,
      g.description,
      g.price,
      g.date,
      g.url_img,
      json_agg(distinct gen.name)::text as genres,
      json_agg(distinct jsonb_build_object(
        'requirementId', r.requirement_id,
        'osId', r.os_id,
        'os', r.os,
        'requirementTypeId', r.requirement_type_id,
        'processor', r.processor,
        'memory', r.memory,
        'graphics', r.graphics
      ))::text as requirements
    from game g
    left join game_genre gg on g.game_id = gg.game_id
    left join genre gen on gg.genre_id = gen.genre_id
    left join requirement r on g.game_id = r.game_id
    where g.game_id = :gameId
    group by g.game_id
    """, nativeQuery = true)
    Map<String, Object> getGameDetailsWithGenresAndRequirements(@Param("gameId") Integer gameId);
}
