package com.model.robot;

import com.model.command.AbstractCommand;
import com.model.command.PlaceCommand;
import com.model.exception.InvalidCommand;

public class RobotFactory {

    public static AbstractRobot getRobot(AbstractCommand initialCommand) throws InvalidCommand {

        if (!(initialCommand instanceof PlaceCommand)) {
            throw new InvalidCommand("First command supplied must be a PlaceCommand");
        }

        return new AbstractRobot((PlaceCommand) initialCommand);
    }

}
