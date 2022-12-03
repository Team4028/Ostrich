// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Infeed extends SubsystemBase {
    private WPI_TalonSRX m_leftYoshi;
    private WPI_TalonSRX m_rightYoshi;
    private WPI_TalonSRX m_leftBlade;
    private WPI_TalonSRX m_rightBlade;

    private static Infeed m_instance;

    /** Creates a new Infeed. */
    public Infeed() {
        m_leftYoshi = new WPI_TalonSRX(11);
        m_rightYoshi = new WPI_TalonSRX(10);

        m_leftBlade = new WPI_TalonSRX(5);
        m_rightBlade = new WPI_TalonSRX(6);

        m_leftBlade.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
                LimitSwitchNormal.NormallyClosed);
        m_rightBlade.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
                LimitSwitchNormal.NormallyClosed);

        m_leftYoshi.setInverted(true);
        m_rightYoshi.setInverted(false);

        m_leftBlade.setInverted(false);
        m_rightBlade.setInverted(true);

    }

    public void runInYoshi() {
        m_leftYoshi.set(0.2);
        m_rightYoshi.set(0.2);
    }

    public void runOutYoshi() {
        m_leftYoshi.set(-0.2);
        m_rightYoshi.set(-0.2);
    }

    public void stopYoshi() {
        m_leftYoshi.set(0);
        m_rightYoshi.set(0);
    }

    public void runBladeForward() {
        m_leftBlade.set(0.2);
        m_rightBlade.set(0.2);
    }

    public void runBladeBackward() {
        m_leftBlade.set(-0.2);
        m_rightBlade.set(-0.2);
    }

    public void stopBlade() {
        m_leftBlade.set(0);
        m_rightBlade.set(0);
    }

    public void stop() {
        m_leftYoshi.set(0);
        m_rightYoshi.set(0);
        m_leftBlade.set(0);
        m_rightBlade.set(0);
    }

    public static Infeed getInstance() {
        if (m_instance == null) {
            m_instance = new Infeed();
        }
        return m_instance;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
