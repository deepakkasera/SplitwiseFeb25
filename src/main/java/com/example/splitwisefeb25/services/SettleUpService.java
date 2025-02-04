package com.example.splitwisefeb25.services;

import com.example.splitwisefeb25.models.Expense;
import com.example.splitwisefeb25.models.ExpenseUser;
import com.example.splitwisefeb25.models.User;
import com.example.splitwisefeb25.repositories.ExpenseUserRepository;
import com.example.splitwisefeb25.repositories.UserRepository;
import com.example.splitwisefeb25.strategies.settleUpStrategy.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;

    public SettleUpService(UserRepository userRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Expense> settleUpUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User with id: " + userId + " doesn't exist.");
        }

        User user = optionalUser.get();

        //Find all the expenses for the given user.
        List<ExpenseUser> expenseUsers = expenseUserRepository.findByUser(user);

        Set<Expense> expensesToSettleUp = new HashSet<>();
        for (ExpenseUser expenseUser : expenseUsers) {
            expensesToSettleUp.add(expenseUser.getExpense());
        }

        List<Expense> settledUpExpenses = settleUpStrategy.settleUp(
                expensesToSettleUp.stream().toList());

        //Instead of returning all the transactions to the user, we can only
        //return the transactions in which either the current user has to pay something or
        // will get back something.
        List<Expense> finalSettledUpExpenses = new ArrayList<>();
        for (Expense expense : settledUpExpenses) {
            for (ExpenseUser expenseUser : expense.getExpenseUsers()) {
                if (expenseUser.getUser().equals(user)) {
                    finalSettledUpExpenses.add(expense);
                    break;
                }
            }
        }


        return finalSettledUpExpenses;
    }

    public List<Expense> settleUpGroup(Long groupId) {
        return null;
    }
}
