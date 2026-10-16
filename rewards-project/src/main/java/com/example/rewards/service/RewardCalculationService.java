package com.example.rewards.service;

import org.springframework.stereotype.Service;

/**
 * Calculates reward points.
 */
@Service
public class RewardCalculationService {

    public long calculatePoints(double amount) {

        if (amount <= 50) {
            return 0;
        }
        if (amount <= 100) {
            return (long) (amount - 50);
        }
        return (long) ((amount - 100) * 2 + 50);
    }
}