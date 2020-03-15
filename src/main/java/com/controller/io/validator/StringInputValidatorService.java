package com.controller.io.validator;

import java.util.regex.Pattern;

public class StringInputValidatorService {

    public static final String VALID_PLACE_REGEX = "PLACE (\\d),(\\d),(NORTH|EAST|SOUTH|WEST)";
    public static final String VALID_MOVE_REGEX = "MOVE";
    public static final String VALID_REPORT_REGEX = "REPORT";

    public static Pattern validPlaceInputPattern = Pattern.compile(VALID_PLACE_REGEX);
    public static Pattern validMoveInputPattern = Pattern.compile(VALID_MOVE_REGEX);
    public static Pattern validReportInputPattern = Pattern.compile(VALID_REPORT_REGEX);

    String input = "";

    public boolean isValidInput(String input) {
        this.input = input;

        return (isValidPlaceInput() || isValidMoveInput() || isValidReportInput());
    }

    boolean isValidPlaceInput() {
        return validPlaceInputPattern.matcher(input).matches();
    }

    boolean isValidMoveInput() {
        return validMoveInputPattern.matcher(input).matches();
    }

    boolean isValidReportInput() {
        return validReportInputPattern.matcher(input).matches();
    }

}
