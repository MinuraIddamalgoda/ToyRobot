package com.controller.io.parser;

import com.controller.io.parser.InputArgParserService;
import org.apache.commons.cli.ParseException;
import org.junit.Test;

import java.io.FileNotFoundException;

public class InputArgParserServiceTest {

    @Test(expected = FileNotFoundException.class)
    public void testValidInputArgs() throws FileNotFoundException, ParseException {
        String[] validArgs = {"-i ./ToyRobot.jar"};
        InputArgParserService parserService = new InputArgParserService(validArgs);

        parserService.getInputFile();
    }

    @Test(expected = ParseException.class)
    public void testInvalidInputArgs() throws FileNotFoundException, ParseException {
        String[] invalidArgs = {"FOOBAR"};
        InputArgParserService parserService = new InputArgParserService(invalidArgs);

        parserService.getInputFile();
    }
}
