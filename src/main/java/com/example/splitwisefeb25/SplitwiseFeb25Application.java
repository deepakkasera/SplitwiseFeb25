package com.example.splitwisefeb25;

import com.example.splitwisefeb25.commands.CommandExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseFeb25Application {
    private static CommandExecutor commandExecutor;

    public SplitwiseFeb25Application(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseFeb25Application.class, args);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.next();

            commandExecutor.execute(input);
        }
    }

}
