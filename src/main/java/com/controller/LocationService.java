package com.controller;

import com.model.command.AbstractCommand;
import com.model.command.ChangeLeftCommand;
import com.model.command.PlaceCommand;
import com.model.robot.Direction;

import static com.lib.BoardConfig.BOARD_HEIGHT;
import static com.lib.BoardConfig.BOARD_WIDTH;

public class LocationService {

    private int currentX;
    private int currentY;
    private Direction currentDirection;

    private final int BOARD_LOWER_BOUND = 0;

    public LocationService(int currentX, int currentY, Direction currentDirection) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.currentDirection = currentDirection;
    }

    public LocationService(PlaceCommand placeCommand) {
        this.currentX = placeCommand.getX();
        this.currentY = placeCommand.getY();
        this.currentDirection = placeCommand.getDirection();
    }

    public Direction changeDirection(AbstractCommand changeDirectionCommand) {
        if (changeDirectionCommand instanceof ChangeLeftCommand) {
            this.currentDirection = Direction.getLeft(getCurrentDirection());
        } else {
            this.currentDirection = Direction.getRight(getCurrentDirection());
        }

        return this.currentDirection;
    }

    public boolean performValidMove() {
        switch (currentDirection) {
            case NORTH:
                if (currentY + 1 <= BOARD_HEIGHT) {
                    currentY++;
                    return true;
                }
            case EAST:
                if (currentX + 1 <= BOARD_WIDTH) {
                    currentX++;
                    return true;
                }
            case WEST:
                if (currentX - 1 >= BOARD_LOWER_BOUND) {
                    currentX--;
                    return true;
                }
            case SOUTH:
                if (currentY - 1 >= BOARD_LOWER_BOUND) {
                    currentY--;
                    return true;
                }
        }

        return false;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }
}
