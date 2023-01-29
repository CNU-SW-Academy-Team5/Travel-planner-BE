package com.sw5.spring.travel.plan.controller;

import com.sw5.spring.travel.plan.ApiResponse;
import com.sw5.spring.travel.plan.dto.DetailedPlanDto;
import com.sw5.spring.travel.plan.dto.PlanDto;
import com.sw5.spring.travel.plan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PlanController {

    @Autowired
    PlanService planService;

    @PostMapping("/plan")
    public ApiResponse<String> savePlan(@RequestBody PlanDto planDto) {
        String id = planService.savePlan(planDto);

        return ApiResponse.ok(id);
    }

    @PostMapping("/detail-plan")
    public ApiResponse<Long> saveDetailedPlan(@RequestBody DetailedPlanDto detailedPlanDto) {
        Long id = planService.saveDetailedPlan(detailedPlanDto);

        return ApiResponse.ok(id);
    }

    @GetMapping("/hello")
    public List<String> Hello() {
        return Arrays.asList("서버 포트는 8080", "리액트 포트는 3000");
    }
}