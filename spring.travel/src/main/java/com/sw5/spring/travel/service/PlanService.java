package com.sw5.spring.travel.service;

import com.sw5.spring.travel.dto.PlanDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public interface PlanService {
    String createPlan(PlanDto planDto);
}
