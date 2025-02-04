package com.example.splitwisefeb25.commands;

import com.example.splitwisefeb25.controllers.SettleUpController;
import com.example.splitwisefeb25.dtos.SettleUpUserRequestDto;
import com.example.splitwisefeb25.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpUserCommand implements Command {
    private SettleUpController settleUpController;

    public SettleUpUserCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) {
        //userId SettleUp
        List<String> words = List.of(input.split(" "));

        return words.size() == 2 && words.get(1).equalsIgnoreCase("SettleUp");
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long userId = Long.valueOf(words.get(0));

        SettleUpUserRequestDto requestDto = new SettleUpUserRequestDto();
        requestDto.setUserId(userId);

        settleUpController.settleUpUser(requestDto);
    }
}
