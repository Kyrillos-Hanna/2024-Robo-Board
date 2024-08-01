// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Motors extends SubsystemBase {
  private final TalonFX m_kraken;
  private final CANSparkMax m_neo;
  private final PWMSparkMax m_cim;
  /** Creates a new Motors. */
  public Motors() {
    m_kraken = new TalonFX(Constants.krakenID, Constants.krakenCanBus);
    m_neo = new CANSparkMax(Constants.neoID, MotorType.kBrushless);
    m_cim = new PWMSparkMax(Constants.cimChannel);
  }

  public Command runKraken(double speed) {
    return run(() -> m_kraken.set(speed));
  }

  public Command runNeo(double speed) {
    return run(() -> m_neo.set(speed));
  }

  public Command runCIM(double speed) {
    return run(() -> m_cim.set(speed));
  }

  public Command turnOff() {
    return run(() -> {
        m_kraken.set(0);
        m_neo.set(0);
        m_cim.set(0);
      }
    );
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
