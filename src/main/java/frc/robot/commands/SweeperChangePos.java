/*
package frc.robot.commands;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;

public class SweeperChangePos extends Command {
	
	private boolean isFinished = false;
	public double setPoint;
	double currentPos = Robot.lift.getPosition();

	
	public SweeperChangePos(double pos) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.sweeper);
		setPoint = pos;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//startTime = Timer.getFPGATimestamp();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
        
		//Robot.sweeper.setPosition(setPoint);
	
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
*/