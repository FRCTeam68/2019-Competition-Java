
package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;



public class Hatchy extends CommandGroup {
	
	boolean isFinished = false;

	double hatchFlag = 0.0;

	public Hatchy() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.hatch);
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		 if(hatchFlag > 0){
			 addSequential(new HatchTimer(3.2, 1));
			 hatchFlag = hatchFlag -1;
		 }
		 else{
			addSequential(new HatchTimer(3.2 , -1));
			hatchFlag = hatchFlag +1;
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
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
