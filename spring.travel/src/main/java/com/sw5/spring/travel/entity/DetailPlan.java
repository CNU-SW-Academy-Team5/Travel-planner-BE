package com.sw5.spring.travel.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@ToString
@Getter
@Entity
@NoArgsConstructor
public class DetailPlan {

    @Id
    @Column
    private UUID detailId;

    @Column
    private String place;

    @Column
    private String time;

    @Column
    private String memo;

    @Column
    private String address;

    @Column
    private UUID planId; //FK

    @Builder
    public DetailPlan(UUID detailId, String place, String time, String memo, String address, UUID planId) {
        this.detailId = detailId;
        this.place = place;
        this.time = time;
        this.memo = memo;
        this.address = address;
        this.planId = planId;
    }
}
