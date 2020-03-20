package com.controller;

import com.model.command.AbstractCommand;
import com.model.command.ChangeLeftCommand;
import com.model.robot.Direction;

public class LocationService {

    private int currentX;
    private int currentY;
    private Direction currentDirection;

    public LocationService(int currentX, int currentY, Direction currentDirection) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.currentDirection = currentDirection;
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
