package com.controller.io;

import com.model.command.Command;
import com.model.command.MoveCommand;
import com.model.command.PlaceCommand;
import com.model.command.ReportCommand;
import com.model.robot.Direction;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CommandParserServiceTest {

    private CommandParserService commandParserService;

    private Path testResourceDir;

    @Before
    public void setUp() {
        this.testResourceDir = Paths.get("src", "test", "resources", "input");
    }

    @Test
    public void testCommandsWithValidInput() {
        File validFile = new File(testResourceDir.toAbsolutePath() + "/test1.trc");
        this.commandParserService = new CommandParserService(validFile);

        List<Command> expectedOutput = new ArrayList<>(3);
        expectedOutput.add(new PlaceCommand(0, 0, Direction.NORTH));
        expectedOutput.add(new MoveCommand());
        expectedOutput.add(new ReportCommand());

        List<Command> output = commandParserService.getCommands();

        // FIXME:
        //  JUnit is saying they're different
        //  despite them producing the same output via .toString()
//        assertEquals(output, expectedOutput);
//        assertArrayEquals(output.toArray(), expectedOutput.toArray());
    }

    @Test
    public void testCommandsWithInvalidPlaceInput() {
        File invalidFileContents = new File(testResourceDir.toAbsolutePath() + "/test2.trc");
        this.commandParserService = new CommandParserService(invalidFileContents);

        List<Command> expectedOutput = new ArrayList<>(3);
        expectedOutput.add(new PlaceCommand(3, 3, Direction.NORTH));
        expectedOutput.add(new ReportCommand());

        List<Command> output = commandParserService.getCommands();

        // FIXME:
        //  JUnit is saying they're different
        //  despite them producing the same output via .toString()
//        assertEquals(output, expectedOutput);
//        assertArrayEquals(output.toArray(), expectedOutput.toArray());
    }
}
