package com.zone.robot.simulator.domain;

import com.zone.robot.simulator.util.GridLocation;

/**
 * Created by jonathanDyke on 30/06/2019.
 */
public class Robot {


    // Instance Data
    private final GridLocation gridLocation;




    /**
     * Default Constructor , using a default location of ORIGIN.
     */
    public Robot() {
        this.gridLocation = GridLocation.origin();
    }

    /**
     * Constructor using suppled Grid Location.
     * @param gridLocation
     */
    public Robot(GridLocation gridLocation) {
        this.gridLocation = gridLocation;
    }


    public void place() {

    }

    public void move() {
        gridLocation.move();
    }

    /**
     * Rotate 90 degrees Left
     */
    public void left() {
        gridLocation.rotate(false);
    }

    /**
     * Rotate 90 Degress Right
     */
    public void right() {
        gridLocation.rotate(true);
    }

    /**
     * Ask the Location object to report on the robot's location.
     */
    public void report() {
        gridLocation.report();

    }



}
