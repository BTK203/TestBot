/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import frc.robot.Constants;
import frc.robot.Commands.*;
import frc.robot.Util.Xbox;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Add your docs here.
 */
public class SubsystemSkrew extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  TalonSRX skrew;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ManualCommandElevator());
  }

  public SubsystemSkrew() {
    skrew = new TalonSRX(Constants.SKREW_ID);
    skrew.setInverted(Constants.SKREW_INVERT);
  }

  public void Elevate(Joystick joy) {
    double throttle = Xbox.LEFT_Y(joy);
    skrew.set(ControlMode.PercentOutput, throttle);
  }
}
