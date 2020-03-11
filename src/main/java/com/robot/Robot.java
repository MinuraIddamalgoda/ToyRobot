package com.robot;

public interface Robot {
    Direction direction = null;
    int x = -1;
    int y = -1;

    boolean move();

    boolean report();
}
