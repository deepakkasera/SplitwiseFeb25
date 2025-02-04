package com.example.splitwisefeb25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "expense_users")
public class ExpenseUser extends BaseModel {
    @ManyToOne
    private Expense expense;

    @ManyToOne
    private User user;

    private Double amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;
}

//XY - X => M:1
//XY - Y => M:1