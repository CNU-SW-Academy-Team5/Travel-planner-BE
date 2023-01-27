package com.sw5.spring.travel.plan.converter;

import com.sw5.spring.travel.domain.plan.DetailedPlan;
import com.sw5.spring.travel.domain.plan.Plan;
import com.sw5.spring.travel.plan.dto.PlanDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PlanConverter {
    // dto -> entity
    public Plan convertPlan(PlanDto planDto) {
        Plan plan = new Plan();
        plan.setId(planDto.getId());
        plan.setName(planDto.getName());
        plan.setStartDate(planDto.getStartDate());
        plan.setEndDate(planDto.getEndDate());
        plan.setRegion(planDto.getRegion());
        plan.setCreatedAt(LocalDateTime.now());
        //plan.setCreatedBy(planDto.getMemberDto().getName());

        return plan;
    }

    //public DetailedPlan convertDetailedPlan()
}
