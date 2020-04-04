package com.model.robot;

import com.model.command.AbstractCommand;
import com.model.command.PlaceCommand;

public class RobotFactory {

    public static AbstractRobot getRobot(AbstractCommand initialCommand) {
        return new AbstractRobot((PlaceCommand) initialCommand);
    }
}
