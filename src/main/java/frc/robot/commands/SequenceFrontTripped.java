/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.RobotMap;

public class SequenceFrontTripped extends CommandGroup {
  /**
   * Add your docs here.
   */
  public SequenceFrontTripped() {
    addSequential(new EndGameWheelsMove(0));
    addSequential(new DriveWithEndGameMotors());
    addSequential(new EndGameMotors(RobotMap.ENDGAME_ZERO, RobotMap.ENDGAME_BACK_LIFTED_POSIITON));
    addSequential(new WaitCommand(.3));
    addSequential(new EndGameWheelsMove(1));
  }
}
