package com.sw5.spring.travel.plan.service;

import com.sw5.spring.travel.domain.plan.DetailedPlan;
import com.sw5.spring.travel.domain.plan.DetailedPlanRepository;
import com.sw5.spring.travel.domain.plan.Plan;
import com.sw5.spring.travel.domain.plan.PlanRepository;
import com.sw5.spring.travel.plan.converter.PlanConverter;
import com.sw5.spring.travel.plan.dto.DetailedPlanDto;
import com.sw5.spring.travel.plan.dto.PlanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private DetailedPlanRepository detailedPlanRepository;

    @Autowired
    private PlanConverter planConverter;

    @Transactional
    public String savePlan(PlanDto planDto) { //이후에 일행도 여기서 같이 저장?
        // dto -> entity
        Plan plan = planConverter.convertPlan(planDto);
        // persistence
        Plan entity = planRepository.save(plan);

        return entity.getId();
    }

    @Transactional
    public Long saveDetailedPlan(DetailedPlanDto detailedPlanDto) {
        // dto -> entity
        DetailedPlan detailedPlan = planConverter.convertDetailedPlan(detailedPlanDto);
        //persistence
        DetailedPlan entity = detailedPlanRepository.save(detailedPlan);

        return entity.getId();
    }
}
