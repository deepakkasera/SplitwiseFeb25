package com.example.splitwisefeb25.commands;

public interface Command {
    boolean matches(String input);

    void execute(String input);
}
