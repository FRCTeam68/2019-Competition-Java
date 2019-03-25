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


public class SweeperPackageIntake extends CommandGroup {
  /**
   * Add your docs here.
   */

  public SweeperPackageIntake() {
      if(!Robot.sweeper.isDeployed()){
      addSequential(new AutoLift(RobotMap.LIFT_ROCKET_CARGO_LOW - 4000));
      addSequential(new WaitCommand(.15));
      addSequential(new AutoWrist(RobotMap.INTAKE_WRIST_HATCH_POSITION));
      addSequential(new WaitCommand(.5));
      addSequential(new SweeperPackage());
      addSequential(new WaitCommand(1));
      addSequential(new AutoLift(RobotMap.LIFT_ROCKET_CARGO_LOW));
      addSequential(new WaitCommand(.5));   
      addSequential(new AutoWrist(RobotMap.INTAKE_WRIST_PACKAGED));
      addSequential(new WaitCommand(.5));   
      addSequential(new AutoLift(RobotMap.LIFT_GROUND));
     }  else if(Robot.sweeper.isDeployed()){
      addSequential(new AutoWrist(RobotMap.INTAKE_WRIST_HATCH_POSITION));
      addSequential(new AutoLift(RobotMap.LIFT_ROCKET_CARGO_LOW));
      addSequential(new WaitCommand(.5));   
      addSequential(new AutoWrist(RobotMap.INTAKE_WRIST_PACKAGED));
      addSequential(new WaitCommand(.5));   
      addSequential(new AutoLift(RobotMap.LIFT_GROUND));
    } 
  }
}
