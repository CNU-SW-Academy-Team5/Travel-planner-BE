package com.sw5.spring.travel.service;

import com.sw5.spring.travel.dto.PlanDto;
import com.sw5.spring.travel.entity.Plan;
import com.sw5.spring.travel.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Transactional
@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService{

    private final PlanRepository planRepository;

    @Transactional
    @Override
    public String createPlan(PlanDto planDto) {
        Plan plan = planDto.dtoToPlanEntity();
        return planRepository.save(plan).getPlanId();
    }
}
