package com.ecommerce.cartmarius.cartmarius_web.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.cartmarius.cartmarius_web.domain.model.Game;

public interface GameRepository extends CrudRepository<Game,Integer>{

    @Query("SELECT g FROM Game g WHERE g.name = :name")
    Optional<Game> buscarPorNombre(@Param("name") String name);
}
