package com.sw5.spring.travel.controller;

import com.sw5.spring.travel.dto.PlanDto;
import com.sw5.spring.travel.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @PostMapping("/plan")
    public ApiResponse<String> savePlan(@RequestBody PlanDto planDto) {
        String id = planService.createPlan(planDto);

        return ApiResponse.ok(id);
    }
}
