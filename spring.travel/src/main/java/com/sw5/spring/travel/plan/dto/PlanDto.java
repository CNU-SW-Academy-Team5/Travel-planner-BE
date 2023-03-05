package com.sw5.spring.travel.plan.dto;

import com.sw5.spring.travel.domain.plan.Region;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
    public class PlanDto {
        private String id;
        private String name;
        private LocalDate startDate;
        private LocalDate endDate;
        private Region region;
        private String createdBy;
        private LocalDateTime createdAt;
        private LocalDateTime lastEdited;
        //association
        private List<DetailedPlanDto> detailedPlansDtos;
}
