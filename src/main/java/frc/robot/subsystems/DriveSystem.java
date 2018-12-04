/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.JoystickDrive;

/**
 * Add your docs here.
 */
public class DriveSystem extends Subsystem {
  private WPI_TalonSRX m_leftController1;
  private WPI_TalonSRX m_leftController2;
  private WPI_TalonSRX m_rightController1;
  private WPI_TalonSRX m_rightController2;
  private SpeedControllerGroup m_leftControlGroup;
  private SpeedControllerGroup m_rightControlGroup;
  private DifferentialDrive m_robotDrive;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public DriveSystem() {
    m_leftController1 = new WPI_TalonSRX(2);
    m_leftController2 = new WPI_TalonSRX(3);
    m_rightController1 = new WPI_TalonSRX(4);
    m_rightController2 = new WPI_TalonSRX(5);
    m_leftControlGroup = new SpeedControllerGroup(m_leftController1, m_leftController2);
    m_rightControlGroup = new SpeedControllerGroup(m_rightController1, m_rightController2);
    m_leftControlGroup.setInverted(false);
    m_rightControlGroup.setInverted(false);
    m_robotDrive = new DifferentialDrive(m_leftControlGroup, m_rightControlGroup);
  }

  public void arcadeDrive(double throttle, double turn){
    m_robotDrive.arcadeDrive(throttle, turn);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new JoystickDrive());
    
  }
}
