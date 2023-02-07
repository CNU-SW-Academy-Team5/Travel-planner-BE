package com.sw5.spring.travel.service;

import java.util.Date;
import java.util.UUID;

public interface PlanService {
    UUID createPlan(String userId, String planName, String lastEdit, Date date);
}
