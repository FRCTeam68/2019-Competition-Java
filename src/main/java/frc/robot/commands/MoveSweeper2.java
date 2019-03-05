
package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class MoveSweeper2 extends Command {
	
	boolean isFinished = false;
	int suc = 0;
	double setPosition;
	
	public MoveSweeper2(double pos) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.sweeper);
		setPosition = pos;
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.sweeper.setPosition(setPosition);
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
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
