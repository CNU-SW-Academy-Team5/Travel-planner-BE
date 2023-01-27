package com.sw5.spring.travel.plan.service;

import com.sw5.spring.travel.domain.plan.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanningService {
    @Autowired
    PlanRepository planRepository;
}
