package com.example.rewards.dto;

import lombok.Data;

@Data
public class MonthlyReward {

    private String month;
    private long points;

    public MonthlyReward() {
    }

    public MonthlyReward(String month, long points) {
        this.month = month;
        this.points = points;
    }

}

