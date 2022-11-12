// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  WPI_TalonSRX m_leftdrivemaster;
  WPI_TalonSRX m_leftdriveslave;
  WPI_TalonSRX m_rightdrivemaster;
  WPI_TalonSRX m_rightdriveslave;
  DifferentialDrive _tankDrive;
  public TankDriveSubsystem() {
    m_leftdrivemaster = new WPI_TalonSRX(1);
    m_leftdriveslave = new WPI_TalonSRX(2);
    MotorControllerGroup _leftdrive = new MotorControllerGroup(m_leftdrivemaster, m_leftdriveslave);
    m_rightdrivemaster = new WPI_TalonSRX(3);
    m_rightdriveslave = new WPI_TalonSRX(4);
    MotorControllerGroup _rightdrive = new MotorControllerGroup(m_rightdrivemaster, m_rightdriveslave);
    _rightdrive.setInverted(true);
    _tankDrive = new DifferentialDrive(_leftdrive, _rightdrive);
  }
  public void tankDriveMethod(double forward, double rotation){
    _tankDrive.arcadeDrive(forward,rotation);
  }

  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
