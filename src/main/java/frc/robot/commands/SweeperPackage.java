
package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.RobotMap;
/**
 *
 */

public class SweeperPackage extends Command {
	
	boolean isFinished = false;

	public SweeperPackage() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.sweeper);

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(!Robot.lift.isManualMode){
		Robot.sweeper.setPosition(RobotMap.SWEEPER_PACKAGED);
		isFinished = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		
	}
}
