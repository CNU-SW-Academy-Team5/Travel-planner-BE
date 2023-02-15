package com.sw5.spring.travel.plan.converter;

import com.sw5.spring.travel.domain.plan.DetailedPlan;
import com.sw5.spring.travel.domain.plan.Plan;
import com.sw5.spring.travel.plan.dto.DetailedPlanDto;
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
        plan.setLastEdited(LocalDateTime.now());
        //plan.setCreatedBy(planDto.getMemberDto().getName());

        return plan;
    }

    public DetailedPlan convertDetailedPlan(DetailedPlanDto detailedPlanDto) {
        DetailedPlan detailedPlan = new DetailedPlan();
        detailedPlan.setId(detailedPlanDto.getId());
        detailedPlan.setStartTime(detailedPlanDto.getStartTime());
        detailedPlan.setEndTime(detailedPlanDto.getEndTime());
        detailedPlan.setLocation(detailedPlanDto.getLocation());
        detailedPlan.setAddress(detailedPlanDto.getAddress());
        detailedPlan.setMemo(detailedPlanDto.getMemo());
        detailedPlan.setCreatedAt(LocalDateTime.now());
        detailedPlan.setLastEdited(LocalDateTime.now());
        //detailedPlan.setCreatedBy(planDto.getMemberDto().getName());
        detailedPlan.setPlan(this.convertPlan(detailedPlanDto.getPlanDto()));

        return detailedPlan;
    }

    // entity -> dto
    public PlanDto convertPlanDto(Plan plan) {
        return PlanDto.builder()
                .id(plan.getId())
                .name(plan.getName())
                .startDate(plan.getStartDate())
                .endDate(plan.getEndDate())
                .region(plan.getRegion())
                .build();
    }

    public DetailedPlanDto convertDetailedPlanDto(DetailedPlan detailedPlan) {
        return DetailedPlanDto.builder()
                .id(detailedPlan.getId())
                .startTime(detailedPlan.getStartTime())
                .endTime(detailedPlan.getEndTime())
                .location(detailedPlan.getLocation())
                .address(detailedPlan.getAddress())
                .memo(detailedPlan.getMemo())
                .planDto(this.convertPlanDto(detailedPlan.getPlan()))
                .build();
    }
}
