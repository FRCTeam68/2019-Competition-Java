/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class LiftSetPosition2 extends Command {
	
	private boolean isFinished = false;
	private double setPoint;
	//private double startTime;
	double currentPos = Robot.lift.getPosition();

	
	public LiftSetPosition2(double position) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lift);
		setPoint = position;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//startTime = Timer.getFPGATimestamp();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (setPoint > RobotMap.LIFT_NORMAL_SCALE) {
			Robot.intake.intakeUpPosition();
		
		}
		if (setPoint < RobotMap.LIFT_GROUND) {
			Robot.intake.intakeClamp();
		} else {
			// MWE - Per Eric - At ground level we should not be clamped
			Robot.intake.intakeNormal();
		}
		
		Robot.lift.setPosition(setPoint);
		if (Math.abs(Robot.lift.getPosition() - setPoint) < 10000) {
			Robot.intake.intakeDownPosition();
		}
		
		
		isFinished = true;

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// MWE
    	if (Robot.lift.getSwitchDown() == false) {
    		Robot.lift.zeroEncoder();
    	}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
