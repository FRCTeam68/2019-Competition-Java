/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.Robot;

public class RumbleManipulatorController extends CommandGroup {
  /**
   * Add your docs here.
   */
  public RumbleManipulatorController() {
    if(Robot.intake.getBeamBreak()){
      Robot.oi.xboxManipulateRumbleStart();
      addSequential(new WaitCommand(1.25));
      Robot.oi.xboxManipulateRumbleStop();
    }
  }
}
