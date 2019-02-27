/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class Constants {

    /**
     * Drivetrain Talon IDs
     */
    public static final int
        RIGHT_MASTER_ID = 1,
        RIGHT_SLAVE_ID  = 2,
        LEFT_MASTER_ID  = 3,
        LEFT_SLAVE_ID   = 4;

    /**
     * Skrew IDs
     */
    public static final int
        SKREW_ID = 11;

    /**
     * Amp limits
     */
    public static final int 
        DRIVE_AMP_LIMIT = 60;

    /**
     * Inverts
     */
    public static final boolean
        DRIVE_INVERT_LEFT  = false,
        DRIVE_INVERT_RIGHT = false,
        SKREW_INVERT       = false;

    /**
     * Ramps
     */
    public static final double
        DRIVE_RAMP = 0;

    /**
     * Solenoid values
     */
    public static final int 
        CLAMP_ID = 5;
}
