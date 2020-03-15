package com.model.command;

import com.model.robot.Direction;

public class PlaceCommand extends Command {

    private int x;
    private int y;
    private Direction direction;

    public PlaceCommand(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public boolean equals(Object obj) {
        PlaceCommand comparison = (PlaceCommand) obj;

        return ((this.x == comparison.x) && (this.y == comparison.y) && this.direction == comparison.direction);
    }

    @Override
    public String toString() {
        return String.format("PLACE %s,%s,%s", x, y, direction);
    }
}
