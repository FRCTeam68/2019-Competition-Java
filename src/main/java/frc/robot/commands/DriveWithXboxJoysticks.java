package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class DriveWithXboxJoysticks extends Command {
	
	boolean isFinished = false;	
	
	public DriveWithXboxJoysticks() {
		
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
			Robot.driveTrain.tankDrive(-Robot.oi.getLeftXboxJoystickValue()*Math.abs(Robot.oi.getLeftXboxJoystickValue())*Math.abs(Robot.oi.getLeftXboxJoystickValue()) *0.9, -Robot.oi.getRightXboxJoystickValue()*Math.abs(Robot.oi.getRightXboxJoystickValue()*Math.abs(Robot.oi.getRightXboxJoystickValue())* 1.5 ));		
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}