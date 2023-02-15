package com.sw5.spring.travel.plan.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedPlanDto {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private String address;
    private String memo;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime lastEdited;
    //association
    private PlanDto planDto;
}
