package com.ecommerce.cartmarius.cartmarius_web.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.cartmarius.cartmarius_web.domain.model.Requirement;

public interface RequirementRepository extends CrudRepository<Requirement,Integer>{

        @Query("SELECT r FROM Requirement r WHERE r.requirementId = :requirementId")
        Optional<Requirement> findRequirementById(@Param("requirementId") Integer requirementId);
}
