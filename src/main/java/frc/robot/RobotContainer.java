// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.BeakXBoxController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Infeed;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    private final BeakXBoxController m_driverController;
    private final DriveTrain m_driveTrain;
    private final Infeed m_infeed;
    // The robot's subsystems and commands are defined here...
    private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

    private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        m_driverController = new BeakXBoxController(0);

        m_driveTrain = DriveTrain.getInstance();
        m_infeed = Infeed.getInstance();
        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
     * it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */

    private void configureButtonBindings() {
        m_driveTrain.setDefaultCommand(new RunCommand(
                () -> m_driveTrain.runDriveTrainMotors(-1.0 * m_driverController.getLeftYAxis(),
                        1.0 * m_driverController.getRightXAxis()),
                m_driveTrain));


        m_driverController.a.toggleWhenPressed(new StartEndCommand(
                () -> m_infeed.runInYoshi(),
                () -> m_infeed.stopYoshi()));
                //m_infeed));

        m_driverController.b.toggleWhenPressed(new StartEndCommand(
                () -> m_infeed.runOutYoshi(),
                () -> m_infeed.stopYoshi()));
               // m_infeed));

        m_driverController.x.toggleWhenPressed(new StartEndCommand(
                () -> m_infeed.runBladeForward(),
                () -> m_infeed.stopBlade()));
                //m_infeed));

        m_driverController.y.toggleWhenPressed(new StartEndCommand(
                () -> m_infeed.runBladeBackward(),
                () -> m_infeed.stopBlade()));
                //m_infeed));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return m_autoCommand;
    }
}