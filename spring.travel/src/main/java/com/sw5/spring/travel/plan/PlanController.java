package com.sw5.spring.travel.plan;

import org.springframework.stereotype.Controller;

@Controller
public class PlanController {
    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }
}
