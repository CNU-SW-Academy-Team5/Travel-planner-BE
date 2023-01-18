package com.sw5.spring.travel.plan;

import com.sw5.spring.travel.user.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PlanService {
    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Plan createPlan(List<DetailPlan> detailPlanList, User user, Date date){
        var plan = new Plan(UUID.randomUUID(), detailPlanList, user, date);
        return planRepository.insert(plan);
    }

    public Plan createPlan(List<DetailPlan> detailPlanList, User user, String planName, String lastEdit, Date date){
        var plan = new Plan(UUID.randomUUID(), detailPlanList, user, planName, lastEdit, date);
        return planRepository.insert(plan);
    }
}
