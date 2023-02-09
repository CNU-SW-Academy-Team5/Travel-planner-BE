package com.sw5.spring.travel.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PlanTest {
    private final Logger logger = LoggerFactory.getLogger(PlanTest.class);

    @Test
    public void createEntityTest(){
        Plan plan = new Plan("planId", UUID.randomUUID(), "제주", "lastEdit", new Date());
        logger.info("planName ->{}", plan.getPlanName());
    }
}