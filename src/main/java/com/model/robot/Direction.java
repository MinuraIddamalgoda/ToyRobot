package com.model.robot;

public enum Direction {
    NORTH,
    EAST,
    WEST,
    SOUTH;

    public static Direction getLeft(Direction comparison) {
        switch (comparison) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            default:
                return null;
        }
    }

    public static Direction getRight(Direction comparison) {
        switch (comparison) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
            case SOUTH:
                return WEST;
            default:
                return null;
        }
    }
}
