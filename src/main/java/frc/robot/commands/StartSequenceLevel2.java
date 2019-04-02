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
import frc.robot.RobotMap;

public class StartSequenceLevel2 extends CommandGroup {
  
private boolean proxBack;
private boolean proxFront;

  public StartSequenceLevel2() 
  {
    requires(Robot.endGame);
    proxBack = Robot.endGame.isGroundBack();
    proxFront = Robot.endGame.isGroundFront();

    addSequential(new EndGameMotors(RobotMap.ENDGAME_FRONT_LIFTED_POSIITON, RobotMap.ENDGAME_BACK_LIFTED_POSIITON));
    addSequential(new WaitCommand(.3));
    addSequential(new EndGameWheelsMove(1));
    if(proxBack == true)
    {
      addSequential(new SequenceBackTripped());
    if(proxFront == true)
    {
      addSequential(new SequenceFrontTripped());
    }
    
    }
    else{
      execute();
    }
  }
}
