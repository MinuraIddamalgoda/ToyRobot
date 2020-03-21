package com.model.robot;

import com.controller.LocationService;
import com.model.command.AbstractCommand;
import com.model.command.PlaceCommand;

public class AbstractRobot {

    LocationService locationService;

    public AbstractRobot(int x, int y, Direction direction) {
        this.locationService = new LocationService(x, y, direction);
    }

    public AbstractRobot(PlaceCommand placeCommand) {
        this.locationService = new LocationService(
                placeCommand.getX(),
                placeCommand.getY(),
                placeCommand.getDirection()
        );
    }

    public void report() {
        System.out.println(String.format("%d,%d,%s",
                locationService.getCurrentX(),
                locationService.getCurrentY(),
                locationService.getCurrentDirection().toString()
        ));
    }

    public boolean move() {
        return this.locationService.performValidMove();
    }

    public void changeDirection(AbstractCommand newDirection) {
        this.locationService.changeDirection(newDirection);
    }
}
