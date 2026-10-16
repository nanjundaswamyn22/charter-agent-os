package com.example.rewards;

import com.example.rewards.service.RewardCalculationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RewardCalculationServiceTest {

    @InjectMocks
    private RewardCalculationService service;

    @Test
    void shouldReturnZeroPoints() {
        assertEquals(0,
                service.calculatePoints(40));
    }

    @Test
    void shouldReturnTwentyFivePoints() {
        assertEquals(25,
                service.calculatePoints(75));
    }

    @Test
    void shouldReturnNinetyPoints() {
        assertEquals(90,
                service.calculatePoints(120));
    }

    @Test
    void shouldReturnTwoHundredFiftyPoints() {
        assertEquals(250,
                service.calculatePoints(200));
    }
}