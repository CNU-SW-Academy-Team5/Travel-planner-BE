package com.sw5.spring.travel.plan;

import com.sw5.spring.travel.user.User;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Plan {
    private final UUID planId;
    private final User user;
    private String planName;
    private String lastEdit;
    private Date date;
    private  List<DetailPlan> detailPlanList;

    public Plan(UUID planId, List<DetailPlan> detailPlanList, User user) {
        this.planId = planId;
        this.detailPlanList = detailPlanList;
        this.user = user;
    }
}
