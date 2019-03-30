/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.RobotMap;

public class EndGameSequenceLevel2 extends CommandGroup {
  /**
   * Add your docs here.
   */
  public EndGameSequenceLevel2() {
    addParallel(new EndGameMotors(RobotMap.ENDGAME_FRONT_LIFTED_POSIITON, RobotMap.ENDGAME_BACK_LIFTED_POSIITON));
  }
}
