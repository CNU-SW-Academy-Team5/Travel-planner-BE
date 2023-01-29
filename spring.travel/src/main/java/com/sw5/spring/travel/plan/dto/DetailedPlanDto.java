package com.sw5.spring.travel.plan.dto;

import lombok.*;
import java.time.LocalDateTime;

@Setter
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
    //association
    private PlanDto planDto;
}
