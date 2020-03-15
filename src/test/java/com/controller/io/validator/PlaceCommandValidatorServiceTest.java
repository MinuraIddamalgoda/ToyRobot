package com.controller.io.validator;

import com.model.command.PlaceCommand;
import com.model.exception.PlacementException;
import com.model.robot.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaceCommandValidatorServiceTest {

    @Test
    public void testGetValidPlaceCommandWithValidInput() throws PlacementException {
        String validPlaceInput = "PLACE 3,2,SOUTH";
        PlaceCommand validPlaceCommand = new PlaceCommand(3, 2, Direction.SOUTH);

        assertEquals(PlaceCommandValidatorService.getValidPlaceCommand(validPlaceInput), validPlaceCommand);
    }

    @Test(expected = PlacementException.class)
    public void testGetValidPlaceCommandWithInvalidInput() throws PlacementException {
        String invalidPlaceInput = "PLACE 6,5,EAST";
        PlaceCommand invalidPlaceCommand = new PlaceCommand(6, 5, Direction.EAST);

        PlaceCommandValidatorService.getValidPlaceCommand(invalidPlaceInput);
    }
}
