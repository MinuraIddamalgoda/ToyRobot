package com.controller.io;

import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileNotFoundException;

public class InputArgParserService {

    private final String INPUT_OPT_SHORT = "i";
    private final String INPUT_OPT_LONG = "input";
    private final String INPUT_OPT_DESCRIPTION = "Input file path";

    private Options options;
    private Option inputFilePathOption;

    String filePath;

    String[] args;

    public InputArgParserService(String[] args) {
        this.args = args;

        this.options = new Options();

        this.inputFilePathOption =
                new Option(INPUT_OPT_SHORT, INPUT_OPT_LONG, true, INPUT_OPT_DESCRIPTION);
        this.inputFilePathOption.setRequired(true);

        this.options.addOption(inputFilePathOption);
    }

    public String getInputPath() throws ParseException, FileNotFoundException {
        if (!hasValidInputArgs()) {
            throw new ParseException("Invalid invocation arguments.");
        }

        if (!isValidPath(filePath)) {
            throw new FileNotFoundException("Cannot read file.");
        }

        return filePath;
    }

    public boolean hasValidInputArgs() {
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine commandLine;

        try {
            commandLine = parser.parse(options, args);
            filePath = commandLine.getOptionValue(INPUT_OPT_SHORT);
            return true;
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            formatter.printHelp("ToyRobot.jar -i <arg>", options);
            return false;
        }
    }

    public boolean isValidPath(String path) {
        File f = new File(path);

        return f.exists() && !f.isDirectory() && f.canRead();
    }
}
