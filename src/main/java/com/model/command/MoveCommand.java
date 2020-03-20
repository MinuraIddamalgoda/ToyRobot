package com.model.command;

public class MoveCommand extends AbstractCommand {
    final int DISTANCE = 1;

    @Override
    public String toString() {
        return "MOVE";
    }
}
