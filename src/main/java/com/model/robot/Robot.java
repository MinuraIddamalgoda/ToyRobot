package com.model.robot;

public interface Robot {
    Direction direction = null;
    int x = -1;
    int y = -1;

    boolean place();

    boolean move();

    boolean report();
}
