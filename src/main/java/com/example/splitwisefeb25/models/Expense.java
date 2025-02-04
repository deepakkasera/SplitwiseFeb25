package com.example.splitwisefeb25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "expenses")
public class Expense extends BaseModel {
    private String description;
    private int amount;

    @OneToMany(mappedBy = "expense")
    private List<ExpenseUser> expenseUsers;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
}
