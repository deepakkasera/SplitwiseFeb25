package com.example.splitwisefeb25.dtos;

import com.example.splitwisefeb25.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private List<Expense> expenses;
}
