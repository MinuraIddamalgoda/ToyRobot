package com.ToyRobot;

import com.controller.io.parser.CommandParserService;
import com.controller.io.parser.InputArgParserService;
import com.model.command.AbstractCommand;
import com.model.exception.InvalidCommand;
import com.model.robot.AbstractRobot;
import com.model.robot.RobotFactory;
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
        List<AbstractCommand> commandList = commandParserService.getCommands();

        try {
            AbstractRobot toyRobot = RobotFactory.getRobot(commandList.get(0));
            System.out.println(toyRobot.report());
        } catch (InvalidCommand invalidCommand) {
            invalidCommand.printStackTrace();
        }
    }
}
