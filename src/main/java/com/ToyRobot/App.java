package com.ToyRobot;

import com.controller.LocationService;
import com.controller.io.parser.CommandParserService;
import com.controller.io.parser.InputArgParserService;
import com.model.command.*;
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

        CommandParserService commandParserService = new CommandParserService(filePath);
        List<AbstractCommand> commandList = commandParserService.getCommands();

        PlaceCommand validInitialPlacement = (PlaceCommand) commandList.remove(0);
        LocationService locationService = new LocationService(validInitialPlacement);

        AbstractRobot toyRobot = RobotFactory.getRobot(locationService);

        for (AbstractCommand command : commandList) {
            if (command instanceof PlaceCommand) {
                toyRobot.performValidMove();
            } else if (command instanceof MoveCommand) {
                toyRobot.performValidMove();
            } else if (command instanceof ReportCommand) {
                System.out.println(toyRobot.report());
            } else if (command instanceof ChangeDirectionCommand) {
                toyRobot.changeDirection(command);
            }
        }
    }
}
