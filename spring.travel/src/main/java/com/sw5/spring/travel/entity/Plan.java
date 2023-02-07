package com.sw5.spring.travel.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@ToString
@Getter
@Entity
@NoArgsConstructor
public class Plan {

    @Id
    @Column
    private String planId;

    @Column
    private UUID userId; //FK

    @Column
    private String planName;

    @Column
    private String lastEdit;

    @Column
    private Date date;

    @Builder
    public Plan(String planId, UUID userId, String planName, String lastEdit, Date date){
        this.planId = planId;
        this.userId = userId;
        this.planName = planName;
        this.lastEdit = lastEdit;
        this.date = date;
    }
}
