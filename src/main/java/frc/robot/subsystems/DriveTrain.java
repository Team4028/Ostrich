// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

    private WPI_TalonSRX m_rightMotorMaster;
    private WPI_TalonSRX m_rightMotorSlave;
    private WPI_TalonSRX m_leftMotorMaster;
    private WPI_TalonSRX m_leftMotorSlave;

    private static DriveTrain m_instance;

    /** Creates a new driveTrain. */
    public DriveTrain() {
        // This method will be called once per scheduler run

        // Left Side Talon -- 1 and 2 -- Master 1:
        m_leftMotorMaster = new WPI_TalonSRX(1);
        m_leftMotorSlave = new WPI_TalonSRX(2);

        m_leftMotorMaster.configFactoryDefault();
        m_leftMotorSlave.configFactoryDefault();

        m_leftMotorMaster.setInverted(false);
        m_leftMotorSlave.setInverted(false);

        m_leftMotorSlave.follow(m_leftMotorMaster);

        // Right Side Talon -- 3 and 4 -- Master 3:
        m_rightMotorMaster = new WPI_TalonSRX(3);
        m_rightMotorSlave = new WPI_TalonSRX(4);

        m_rightMotorMaster.configFactoryDefault();
        m_rightMotorSlave.configFactoryDefault();

        m_rightMotorMaster.setInverted(true);
        m_rightMotorSlave.setInverted(true);

        m_rightMotorSlave.follow(m_rightMotorMaster);
    }

    public void runDriveTrainMotors(double vbus, double turn) {
        m_leftMotorMaster.set(0.7 * vbus - 0.3 * turn);
        m_rightMotorMaster.set(0.7 * vbus + 0.3 * turn);
    }

    public static DriveTrain getInstance() {
        if (m_instance == null) {
            m_instance = new DriveTrain();
        }
        return m_instance;
    }
    
    @Override
    public void periodic() {

    }
}