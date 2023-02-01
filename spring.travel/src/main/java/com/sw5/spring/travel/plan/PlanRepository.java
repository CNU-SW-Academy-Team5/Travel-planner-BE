package com.sw5.spring.travel.plan;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlanRepository {

    List<Plan> findAll();

    Plan insert(Plan plan);

    Plan update(Plan plan);

    Optional<Plan> findById(UUID planId);

    void delete();
}
