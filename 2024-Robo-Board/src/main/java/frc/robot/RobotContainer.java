// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.*;


public class RobotContainer {
  private final Motors m_motors = new Motors();
  private final CommandXboxController m_controller = new CommandXboxController(0);
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_controller.a().whileTrue(m_motors.runKraken(0.5));
    m_controller.b().whileTrue(m_motors.runNeo(0.5));
    m_controller.x().whileTrue(m_motors.runCIM(0.5));

    m_controller.a().whileFalse(m_motors.runKraken(0));
    m_controller.b().whileFalse(m_motors.runNeo(0));
    m_controller.x().whileFalse(m_motors.runCIM(0));

    m_motors.setDefaultCommand(m_motors.turnOff());
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
