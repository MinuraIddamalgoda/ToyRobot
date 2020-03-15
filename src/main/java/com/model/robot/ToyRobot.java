package com.model.robot;

public class ToyRobot implements Robot {
    Direction direction;
    int x = -1;
    int y = -1;

    @Override
    public boolean place() {
        return false;
    }

    @Override
    public boolean move() {
        return false;
    }

    @Override
    public boolean report() {
        return false;
    }
}
