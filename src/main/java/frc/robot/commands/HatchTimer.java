package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class HatchTimer extends Command {
	
	boolean isFinished = false;
    double timeLimit = 0.0;
	double timeToRun = 0.0;
	double hookSpeed = 0.0;
    Timer timer = new Timer();
    
	public HatchTimer(double time, double speed) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.hatch);
        timeToRun = time;
    	hookSpeed = speed;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		timeLimit = timeToRun + Timer.getFPGATimestamp();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
        Robot.hatch.setHatchSpeed(hookSpeed);
        if(Timer.getFPGATimestamp() > timeLimit)
    	{
    		isFinished = true;
    	}
    	else
    	{
    		isFinished = false;
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
        Robot.hatch.setHatchSpeed(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
