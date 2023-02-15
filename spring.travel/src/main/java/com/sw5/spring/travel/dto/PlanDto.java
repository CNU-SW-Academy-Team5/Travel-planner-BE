package com.sw5.spring.travel.dto;

import com.sw5.spring.travel.entity.Plan;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class PlanDto {
    private String planId;

    private UUID userId;

    private String planName;

    private String lastEdit;

    private Date date;

    @Builder
    public PlanDto(String planId, UUID userId, String planName, String lastEdit, Date date){
        this.planId = planId;
        this.userId = userId;
        this.planName = planName;
        this.lastEdit = lastEdit;
        this.date = date;
    }

    public Plan dtoToPlanEntity(){
        return Plan.builder()
                .userId(userId)
                .planName(planName)
                .lastEdit(lastEdit)
                .date(date)
                .build();
    }
}
