package com.example.splitwisefeb25.commands;

import com.example.splitwisefeb25.controllers.UserController;
import com.example.splitwisefeb25.dtos.RegisterUserRequestDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserCommand implements Command {
    private UserController userController;

    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));

        return words.size() == 4 && words.get(0).equals("Register");
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        String name = words.get(0);
        String phoneNumber = words.get(1);
        String password = words.get(2);

        RegisterUserRequestDto requestDto = new RegisterUserRequestDto();
        requestDto.setName(name);
        requestDto.setPhoneNumber(phoneNumber);
        requestDto.setPassword(password);

        userController.registerUser(requestDto);
    }
}


/*
Register vinsmokesanji 003 namisswwaann
 */