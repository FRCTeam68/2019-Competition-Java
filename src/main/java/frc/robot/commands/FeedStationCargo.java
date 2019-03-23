/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;

public class FeedStationCargo extends CommandGroup {
  /**
   * Add your docs here.
   */
  public FeedStationCargo() {
    // Add Commands here:
    addSequential(new AutoLift(RobotMap.LIFT_ROCKET_HATCH_MID));
    addSequential(new AutoWrist(RobotMap.INTAKE_WRIST_CARGO_OUTPUT));
  }
}
