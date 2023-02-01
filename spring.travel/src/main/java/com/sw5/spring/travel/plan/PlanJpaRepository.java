package com.sw5.spring.travel.plan;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PlanJpaRepository implements PlanRepository{

    @Override
    public List<Plan> findAll() {
        return null;
    }

    @Override
    public Plan insert(Plan plan) {
        return null;
    }

    @Override
    public Plan update(Plan plan) {
        return null;
    }

    @Override
    public Optional<Plan> findById(UUID planId) {
        return Optional.empty();
    }

    @Override
    public void delete() {

    }
}
