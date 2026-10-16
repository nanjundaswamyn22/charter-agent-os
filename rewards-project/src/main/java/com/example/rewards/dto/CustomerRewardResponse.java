package com.example.rewards.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerRewardResponse{

   private Long customerId;

   private String customerName;

   private List<MonthlyReward> monthlyRewards;

   private long totalRewards;

}
