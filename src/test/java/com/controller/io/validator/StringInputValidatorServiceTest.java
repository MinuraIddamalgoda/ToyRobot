package com.controller.io.validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringInputValidatorServiceTest {

    private StringInputValidatorService validatorService;

    @Before
    public void setUp() {
        this.validatorService = new StringInputValidatorService();
    }

    @Test
    public void testWithValidPlaceInput() {
        String validPlaceInput = "PLACE 0,0,NORTH";

        assertTrue(validatorService.isValidInput(validPlaceInput));
    }

    @Test
    public void testWithInvalidPlaceInput() {
        String invalidPlaceInput = "Place 0,southwest";

        assertFalse(validatorService.isValidInput(invalidPlaceInput));
    }

    @Test
    public void testWithValidMoveInput() {
        String validMoveInput = "MOVE";

        assertTrue(validatorService.isValidInput(validMoveInput));
    }

    @Test
    public void testWithInvalidMoveInput() {
        String invalidMoveInput = "moved";

        assertFalse(validatorService.isValidInput(invalidMoveInput));
    }

    @Test
    public void testWithValidReportInput() {
        String validReportInput = "REPORT";

        assertTrue(validatorService.isValidInput(validReportInput));
    }

    @Test
    public void testWithInvalidReportInput() {
        String invalidReportInput = "reporter";

        assertFalse(validatorService.isValidInput(invalidReportInput));
    }
}
