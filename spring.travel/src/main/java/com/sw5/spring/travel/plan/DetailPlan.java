package com.sw5.spring.travel.plan;

import java.util.UUID;

public class DetailPlan {
    private final UUID detailId;
    private final String Place;
    private String time;
    private String memo;
    private final String Address;
    private final Plan mainPlan;

    public DetailPlan(UUID detailId, String place, String time, String memo, String address, Plan mainPlan) {
        this.detailId = detailId;
        Place = place;
        this.time = time;
        this.memo = memo;
        Address = address;
        this.mainPlan = mainPlan;
    }

    public UUID getDetailId() {
        return detailId;
    }

    public String getPlace() {
        return Place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getAddress() {
        return Address;
    }

    public Plan getMainPlan() {
        return mainPlan;
    }
}
