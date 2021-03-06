/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class SubsystemClamp extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Solenoid clamp;
  //private Solenoid test;
  private boolean clamped = false;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public SubsystemClamp() {
    clamp = new Solenoid(Constants.CLAMP_ID);
    //test = new Solenoid(6);
  }

  public void ToggleClamp() {
    DriverStation.reportWarning("TOGGLE CLAMP", false);
    clamp.set(clamped);
    //test.set(!clamped);
    clamped = !clamped;
  }

}
