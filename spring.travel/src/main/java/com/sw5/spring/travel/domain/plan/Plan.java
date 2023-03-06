package com.sw5.spring.travel.domain.plan;

import com.sw5.spring.travel.domain.BaseEntity;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plan")
@Getter
@Setter
public class Plan extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "start_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate endDate;
    @Column(name = "region", nullable = false)
    private Region region;

    @OneToMany(mappedBy = "plan")
    private List<DetailedPlan> detailedPlans = new ArrayList<>();

    // auto association
    public void addDetailedPlan(DetailedPlan detailedPlan) { detailedPlan.setPlan(this);}
}
