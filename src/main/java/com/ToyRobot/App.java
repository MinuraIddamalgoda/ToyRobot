package com.ToyRobot;

import com.controller.io.InputArgParserService;
import org.apache.commons.cli.ParseException;

import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) {
        InputArgParserService parserService = new InputArgParserService(args);
        String filePath = "";

        try {
            filePath = parserService.getInputPath();
        } catch (ParseException | FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        System.out.println(filePath);
    }
}
