package com.example.splitwisefeb25.strategies.settleUpStrategy;

import com.example.splitwisefeb25.models.Expense;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class HeapSettleUpStrategy implements SettleUpStrategy {

    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        //Min Heap and Max Heap Algorithm.
        //TODO: Refer notes for the algo part.
        return new ArrayList<>();
    }
}
