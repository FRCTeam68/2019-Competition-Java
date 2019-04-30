
package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import org.opencv.core.Mat;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;


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
		if(!Robot.lift.isManualMode){
			Robot.intake.setIntakeSpeed(-joystickSpeed); 
			if(Robot.sweeper.isDeployed()){
				Robot.sweeper.setSweeperSpeed(joystickSpeed);
				Robot.intake.setIntakeSpeed(-joystickSpeed); 
				if(joystickSpeed > .25 && Robot.intake.getBeamBreak() == true){
					Scheduler.getInstance().add(new DeliverCargo());		
				} else if(joystickSpeed > .05 && Robot.intake.getBeamBreak() == true ){
					Robot.intake.setIntakeSpeed(0); 
				} else if(joystickSpeed < -.05 && Robot.intake.getBeamBreak() == true){
					Robot.intake.setIntakeSpeed(-joystickSpeed); 
				}
			} 
		} else {
			Robot.sweeper.setSweeperSpeed(joystickSpeed);
			Robot.intake.setIntakeSpeed(-joystickSpeed); 
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
