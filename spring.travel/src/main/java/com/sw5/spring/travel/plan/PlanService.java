package com.sw5.spring.travel.plan;

import com.sw5.spring.travel.plan.PlanRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanService {
    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }


}
