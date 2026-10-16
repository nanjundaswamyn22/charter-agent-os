package com.example.rewards.service;

import com.example.rewards.dto.CustomerRewardResponse;
import com.example.rewards.dto.MonthlyReward;
import com.example.rewards.entity.Customer;
import com.example.rewards.entity.Transaction;
import com.example.rewards.exception.CustomerNotFoundException;
import com.example.rewards.repository.CustomerRepository;
import com.example.rewards.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RewardService {

    private final CustomerRepository customerRepository;

    private final TransactionRepository transactionRepository;

    private final RewardCalculationService calculationService;

    public RewardService(
            CustomerRepository customerRepository,
            TransactionRepository transactionRepository,
            RewardCalculationService calculationService) {

        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
        this.calculationService = calculationService;
    }

    public CustomerRewardResponse getCustomerRewards(
            Long customerId) {

        Customer customer =
                customerRepository.findById(customerId)
                        .orElseThrow(() ->
                                new CustomerNotFoundException(
                                        "Customer not found " + customerId));

        List<Transaction> transactions =
                transactionRepository.findByCustomerId(customerId);

        Map<YearMonth, Long> monthlyPoints =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                t -> YearMonth.from(
                                        t.getTransactionDate()),
                                Collectors.summingLong(
                                        t -> calculationService
                                                .calculatePoints(
                                                        t.getAmount())
                                )));

        List<MonthlyReward> rewards =
                monthlyPoints.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .map(entry ->
                                new MonthlyReward(
                                        entry.getKey().toString(),
                                        entry.getValue()))
                        .toList();

        long totalRewards =
                monthlyPoints.values()
                        .stream()
                        .mapToLong(Long::longValue)
                        .sum();

        CustomerRewardResponse response =
                new CustomerRewardResponse();

        response.setCustomerId(customer.getId());
        response.setCustomerName(customer.getName());
        response.setMonthlyRewards(rewards);
        response.setTotalRewards(totalRewards);

        return response;
    }

    public List<CustomerRewardResponse> getAllCustomersRewards() {

        return customerRepository.findAll()
                .stream()
                .map(customer ->
                        getCustomerRewards(customer.getId()))
                .toList();
    }
}