
package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;


public class IntakeManual extends Command {
	
	private boolean isFinished = false;
	private double joystickSpeed = 0;
	
	public IntakeManual() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

		joystickSpeed = Robot.oi.getRightXboxManipulatorJoystick();
		if(joystickSpeed < -0.01){
		Robot.intake.setIntakeSpeed(-Robot.oi.getRightXboxManipulatorJoystick()/2); 
		} else if(joystickSpeed > 0.01){
			Robot.intake.setIntakeSpeed(-Robot.oi.getRightXboxManipulatorJoystick()); 
		}
		if(Robot.sweeper.lastSweeperPos() == RobotMap.SWEEPER_DEPLOYED){
			Robot.sweeper.setSweeperSpeed(joystickSpeed);
			if(joystickSpeed > .25 && Robot.intake.getBeamBreak() == true){
				Scheduler.getInstance().add(new DeliverCargo());
			}
		} 

		if(Robot.intake.getBeamBreak()){
			Scheduler.getInstance().add(new RumbleManipulatorController());
			
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
