package com.sw5.spring.travel.service;

import com.sw5.spring.travel.dto.PlanDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
class PlanServiceImplTest {

    private PlanServiceImpl planService;

    @Test
    void createTest(){
        PlanDto planDto = PlanDto.builder()
                .planId("1")
                .userId(UUID.randomUUID())
                .planName("제주여행")
                .lastEdit("2023-02-15")
                .date(new Date())
                .build();
        String createdPlanId = planService.createPlan(planDto);
        assertThat("1", createdPlanId);

    }
}