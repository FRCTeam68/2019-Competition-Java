/* this is a place holder for the end game command */
package frc.robot.commands;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class EndGameSetPosition extends Command {
	
	private boolean isFinished = false;
	public double setPoint;


	
	public EndGameSetPosition() {
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.EndGame); ADD ENDGAME TO ROBOT
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//startTime = Timer.getFPGATimestamp();
	}

	// Called repeatedly when this Command is scheduled to run+
	@Override
	protected void execute() {
		
		// if the sensor is at the position the set it to this point

		Robot.endGame.setBackMotorPos(setPoint);
		Robot.endGame.setFrontMotorPos(setPoint);
        
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