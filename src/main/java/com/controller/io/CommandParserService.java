package com.controller.io;

import com.controller.io.validator.PlaceCommandValidatorService;
import com.controller.io.validator.StringInputValidatorService;
import com.model.command.Command;
import com.model.command.MoveCommand;
import com.model.command.PlaceCommand;
import com.model.command.ReportCommand;
import com.model.exception.PlacementException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandParserService {

    File inputFile;

    private final String PLACE_COMMAND_START = "PLACE";
    private final String MOVE_COMMAND = "MOVE";
    private final String REPORT_COMMAND = "REPORT";

    private StringInputValidatorService inputValidator;

    public CommandParserService(File inputFile) {
        this.inputFile = inputFile;
        this.inputValidator = new StringInputValidatorService();
    }

    public List<Command> getCommands() {
        List<Command> commandList = new ArrayList<>();

        for (String line : getFileContents()) {
            if (line.startsWith(PLACE_COMMAND_START)) {
                try {
                    commandList.add(PlaceCommandValidatorService.getValidPlaceCommand(line));
                } catch (PlacementException e) {
                    System.err.println("INVALID PLACEMENT");
                }
            } else if (line.startsWith(MOVE_COMMAND)) {
                commandList.add(new MoveCommand());
            } else if (line.startsWith(REPORT_COMMAND)) {
                commandList.add(new ReportCommand());
            }
        }

        return ignoreUnplacedCommands(commandList);
    }

    List<Command> ignoreUnplacedCommands(List<Command> commandList) {
        List<Command> validCommandList = new ArrayList<>(commandList.size());
        boolean robotHasBeenPlaced = false;

        for (Command command : commandList) {
            if (command instanceof PlaceCommand) {
                robotHasBeenPlaced = true;
            }

            if (robotHasBeenPlaced) {
                validCommandList.add(command);
            }
        }

        return validCommandList;
    }

    List<String> getFileContents() {
        List<String> lines = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(inputFile.getPath()))) {
            stream.forEach(lines::add);
        } catch (IOException ignored) {
            // Can ignore as file readability as already been validated
        }

        return lines.stream()
                .filter(line -> inputValidator.isValidInput(line))
                .collect(Collectors.toList());
    }
}
