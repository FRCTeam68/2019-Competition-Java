package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.*;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.RobotMap;
/**
 *
 */
public class IntakeManual extends Command {
	
	boolean isFinished = false;
	int suc = 0;
	
	public IntakeManual() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.intake);
		requires(Robot.wrist);
		requires(Robot.sweeper);
		requires(Robot.lift);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

		 Robot.intake.setIntakeSpeed(Robot.oi.getLeftXboxManipulatorJoystick(), -Robot.oi.getLeftXboxManipulatorJoystick());
		 Robot.sweeper.setSweeperSpeed(Robot.oi.getLeftXboxManipulatorJoystick(), -Robot.oi.getLeftXboxManipulatorJoystick());
		 
		 if(Robot.intake.findCurrentStateOfBeamBreak() == true){

			Robot.intake.setIntakeSpeed( 0.00 , 0.00);
			Robot.sweeper.setSweeperSpeed(0.00, 0.00);
			Robot.lift.setPosition(32200.0); 
			
			if(Robot.lift.getPosition() == 32200.0){
			//Robot.sweeper.setPosition(position);
			}
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
		Robot.intake.setIntakeSpeed(RobotMap.INTAKE_SPEED_STOP, RobotMap.INTAKE_SPEED_STOP);
	}
}