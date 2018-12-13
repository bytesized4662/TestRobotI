/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*prgmr                date          comment                                  */
/*Casey A Marshall      12/3/2018     None                                    */
/******************************************************************************/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;

public class OI {
  
  private Joystick m_driveStick;

  public OI() {
    m_driveStick = new Joystick(0);
  }

  public double getDriveStickThrottle() {
    return m_driveStick.getY();
  }

  public double getDriveStickTurn() {
    return m_driveStick.getZ();
  }

  public double getDriveStickSpeed(){
    double throttle = m_driveStick.getThrottle();
    if (m_driveStick.getY() < 0 ){
    return 2.0 / (throttle + 3.0);
    }else{
    return -2.0 / (throttle + 3.0);
    }
  }
  // The Rebels are attacking the Empire!
}

