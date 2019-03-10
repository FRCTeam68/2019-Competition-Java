
package frc.robot.commands;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class AutoLiftLB extends Command {
	
	private boolean isFinished = false;
	public double setPoint;
	double currentPos = Robot.lift.getPosition();

	
	public AutoLiftLB() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lift);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//startTime = Timer.getFPGATimestamp();
	}

	// Called repeatedly when this Command is scheduled to run+
	@Override
	protected void execute() {
		
		 if(Robot.oi.getXboxManipulateLB()) {
			if(Robot.oi.getXboxManipulateA() || Robot.oi.getXboxManipulateB() ){
				setPoint = RobotMap.LIFT_ROCKET_CARGO_LOW;
			} else if (Robot.oi.getXboxManipulateX()) {
				setPoint = RobotMap.LIFT_ROCKET_CARGO_MID;
			} else if (Robot.oi.getXboxManipulateY()) {
				setPoint = RobotMap.LIFT_ROCKET_CARGO_HIGH;
			} 
		}

		Robot.lift.setPosition(setPoint);
	
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