package com.sw5.spring.travel.dto;

import com.sw5.spring.travel.entity.Plan;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class PlanDto {
    private String planId;

    private UUID userId;

    private String planName;

    private String lastEdit;

    private Date date;

    public Plan dtoToPlanEntity(){
        return Plan.builder()
                .userId(userId)
                .planName(planName)
                .lastEdit(lastEdit)
                .date(date)
                .build();
    }
}
