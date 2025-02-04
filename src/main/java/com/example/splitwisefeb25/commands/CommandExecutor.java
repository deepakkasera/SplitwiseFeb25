package com.example.splitwisefeb25.commands;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandExecutor {
    private RegisterUserCommand registerUserCommand;
    private SettleUpUserCommand settleUpUserCommand;
    //....More commands

    private List<Command> commands;

    public CommandExecutor(RegisterUserCommand registerUserCommand,
                           SettleUpUserCommand settleUpUserCommand) {
        this.registerUserCommand = registerUserCommand;
        this.settleUpUserCommand = settleUpUserCommand;

        commands.add(registerUserCommand);
        commands.add(settleUpUserCommand);
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void execute(String input) {
        for (Command command : commands) {
            if (command.matches(input)) {
                command.execute(input);
                break;
            }
        }
    }
}
