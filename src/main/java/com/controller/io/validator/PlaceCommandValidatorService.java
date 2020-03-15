package com.controller.io.validator;

import com.model.command.PlaceCommand;
import com.model.exception.PlacementException;
import com.model.robot.Direction;

public class PlaceCommandValidatorService {

    private static final int BOARD_WIDTH = 5;
    private static final int BOARD_HEIGHT = 5;

    public static PlaceCommand getValidPlaceCommand(String command) throws PlacementException {
        String[] commandContents = command.split(" ");
        String[] positionInformation = commandContents[1].split(",");

        int x = Integer.parseInt(positionInformation[0]);
        int y = Integer.parseInt(positionInformation[1]);
        Direction direction = Direction.valueOf(positionInformation[2]);

        if ((x >= 0 && x <= BOARD_WIDTH) && (y >= 0 && y <= BOARD_HEIGHT)) {
            return new PlaceCommand(x, y, direction);
        }

        throw new PlacementException("Robot must be placed within board.");
    }
}
