package com.example.splitwisefeb25.strategies.settleUpStrategy;

import com.example.splitwisefeb25.models.Expense;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BruteForceSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        return new ArrayList<>();
    }
}
