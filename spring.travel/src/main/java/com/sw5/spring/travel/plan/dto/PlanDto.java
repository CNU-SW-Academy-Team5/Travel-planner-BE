package com.sw5.spring.travel.plan.dto;

import com.sw5.spring.travel.domain.plan.Region;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanDto {
    private String id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Region region;
    //association
    private List<DetailedPlanDto> detailedPlansDtos;
}