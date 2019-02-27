/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import frc.robot.Constants;
import frc.robot.Commands.ManualCommandDrive;
import frc.robot.Util.Xbox;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DriverStation;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

/**
 * Add your docs here.
 */
public class SubsytemDrive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  private TalonSRX rightMaster;
  private TalonSRX leftMaster;
  private TalonSRX rightSlave;
  private TalonSRX leftSlave;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ManualCommandDrive());
  }

  /**
   * Creates the drivetrain
   */
  public SubsytemDrive() {
    rightMaster = new TalonSRX(Constants.RIGHT_MASTER_ID);
    rightSlave  = new TalonSRX(Constants.RIGHT_SLAVE_ID);
    leftMaster  = new TalonSRX(Constants.LEFT_MASTER_ID);
    leftSlave   = new TalonSRX(Constants.LEFT_SLAVE_ID);

    init(Constants.DRIVE_AMP_LIMIT, Constants.DRIVE_INVERT_RIGHT, Constants.DRIVE_INVERT_LEFT);

    DriverStation.reportWarning("DRIVETRAIN CREATED!", false);
  }

  public void TankDrive(Joystick joy) {
    //get throttle and turn from the xbox controller
    double throttle = Xbox.RT(joy) - Xbox.LT(joy);
    double turn     = Xbox.LEFT_X(joy);

    //create the left and right motor throttles
    double left = throttle + turn;
    double right = throttle - turn;

    //make sure that the values are in range
    left  = (left > 1.0 ? left = 1.0 : (left < -1.0 ? left = -1.0 : left));
    right = (right > 1.0 ? right = 1.0 : (right < -1.0 ? right = -1.0 : right));

    //set the motor values
    rightMaster.set(ControlMode.PercentOutput, right);
    rightSlave.set(ControlMode.PercentOutput, right);
    leftMaster.set(ControlMode.PercentOutput, left);
    leftSlave.set(ControlMode.PercentOutput, left);
  }
  /**
   * sets motor amp limits, braking, and other things
   */
  public void init(int ampLimit, boolean rightInvert, boolean leftInvert) {
    rightMaster.configContinuousCurrentLimit(ampLimit);
    rightSlave.configContinuousCurrentLimit(ampLimit);
    leftMaster.configContinuousCurrentLimit(ampLimit);
    leftSlave.configContinuousCurrentLimit(ampLimit);

    rightMaster.setInverted(rightInvert);
    rightSlave.setInverted(rightInvert);
    leftMaster.setInverted(leftInvert);
    leftMaster.setInverted(leftInvert);

    rightSlave.configOpenloopRamp(Constants.DRIVE_RAMP);
  }
}
