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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Add your docs here.
 */
public class SubsystemSkrew extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private TalonSRX skrew;
  private DigitalInput upperLimit;
  private DigitalInput lowerLimit;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ManualCommandElevator());
  }

  public SubsystemSkrew() {
    skrew = new TalonSRX(Constants.SKREW_ID);
    skrew.setInverted(Constants.SKREW_INVERT);

    //limits
    upperLimit = new DigitalInput(Constants.SKREW_UPPER_SWITCH_ID);
    lowerLimit = new DigitalInput(Constants.SKREW_LOWER_SWITCH_ID);

  }

  public void Elevate(Joystick joy) {
    double throttle = Xbox.LEFT_Y(joy);

    if(!upperLimit.get() && throttle > 0) { 
      throttle = 0;
      DriverStation.reportWarning("UPPER LIMIT", false);
    }

    if(!lowerLimit.get() && throttle < 0) {
      throttle = 0;
      DriverStation.reportWarning("LOWER LIMIT", false);
    }

    throttle *= Constants.SKREW_INHIBITOR;
    skrew.set(ControlMode.PercentOutput, throttle);
  }
}
