package com.ToyRobot;

import com.controller.io.parser.CommandParserService;
import com.controller.io.parser.InputArgParserService;
import com.model.command.Command;
import org.apache.commons.cli.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class App {

    public static void main(String[] args) {
        InputArgParserService inputArgParserService = new InputArgParserService(args);

        File filePath = null;

        try {
            filePath = inputArgParserService.getInputFile();
        } catch (ParseException | FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        System.out.println(filePath);

        CommandParserService commandParserService = new CommandParserService(filePath);
        List<Command> commandList = commandParserService.getCommands();

        for (Command command: commandList) {
            System.out.println(command.toString());
        }
    }
}
