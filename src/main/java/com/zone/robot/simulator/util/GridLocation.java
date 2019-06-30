package com.zone.robot.simulator.util;

import com.zone.robot.simulator.domain.TableTop;

/**
 * Created by jonathanDyke on 30/06/2019.
 */
public class GridLocation {


    // Instance Variables
    private  int x_axis;
    private  int y_axis;
    private FACING facingDirection;


    // Nested Cohesive Enum
    public enum FACING {
        NORTH, SOUTH, EAST, WEST
    }



    public GridLocation(int x_axis, int y_axis, FACING facingDirection ) {
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.facingDirection = facingDirection;
    }


    /**
     * Increment the current direction by 1 unit.
     */
    public void move() {

        switch(facingDirection) {

            case NORTH :
                if ( y_axis + 1 < TableTop.getMaxYAxisSize()) {
                y_axis++;
                break;
            }
            case SOUTH :
                if ( y_axis - 1 >= 0 ) {
                    y_axis--;
                    break;
                }
            case WEST :
                if ( x_axis - 1 >= 0 ) {
                    x_axis--;
                    break;
                }
            case EAST :
                if ( x_axis + 1 < TableTop.getMaxXAxisSize()) {
                    x_axis++;
                    break;
                }
                break;
            default: break;
        }
    }


    public void rotate(boolean clockwise) {

        switch(facingDirection) {

            case NORTH :
                if ( clockwise )
                    facingDirection = FACING.EAST;
                else
                    facingDirection = FACING.WEST;
                break;

            case SOUTH :
                if ( clockwise )
                    facingDirection = FACING.WEST;
                else
                    facingDirection = FACING.EAST;
                break;

            case WEST :
                if ( clockwise )
                    facingDirection = FACING.NORTH;
                else
                    facingDirection = FACING.SOUTH;
                break;

            case EAST :
                if ( clockwise )
                    facingDirection = FACING.SOUTH;
                else
                    facingDirection = FACING.NORTH;
                break;

            default: break;
        }

    }


    /**
     * Static helper method to provide the 'Origin'
     * @return
     */
    public static GridLocation origin() {
        return new GridLocation(0,0, FACING.EAST);

    }


    public void report() {
        System.out.println("Robot Location OUTPUT :" + x_axis + "," + y_axis + "," + facingDirection);
    }

}
