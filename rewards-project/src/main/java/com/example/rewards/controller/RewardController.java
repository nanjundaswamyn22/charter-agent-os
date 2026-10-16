package com.example.rewards.controller;

import com.example.rewards.dto.CustomerRewardResponse;
import com.example.rewards.service.RewardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(
            RewardService rewardService) {
        this.rewardService = rewardService;
    }

    /**
     * Returns rewards of all customers.
     */
    @GetMapping
    public List<CustomerRewardResponse> getRewards() {

        return rewardService.getAllCustomersRewards();
    }

    /**
     * Returns rewards for a specific customer.
     */
    @GetMapping("/{customerId}")
    public CustomerRewardResponse getRewards(
            @PathVariable Long customerId) {

        return rewardService.getCustomerRewards(
                customerId);
    }
}