package com.sw5.spring.travel.domain.plan;

import com.sw5.spring.travel.domain.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class DetailedPlan extends BaseEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "start_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime startTime;
    @Column(name = "end_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime endTime;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "address")
    private String address;
    @Column(name = "memo")
    private String memo;

    @ManyToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    private Plan plan;

    // auto association
    public void setPlan(Plan plan) {
        if(Objects.nonNull(this.plan)) {
            this.plan.getDetailedPlans().remove(this);
        }

        this.plan = plan;
        plan.getDetailedPlans().add(this);
    }
}
