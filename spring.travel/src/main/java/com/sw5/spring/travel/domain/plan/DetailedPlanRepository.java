package com.sw5.spring.travel.domain.plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailedPlanRepository extends JpaRepository<DetailedPlan, Long> {
}
