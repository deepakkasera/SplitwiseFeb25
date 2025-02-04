package com.example.splitwisefeb25.strategies.settleUpStrategy;

import com.example.splitwisefeb25.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
}
