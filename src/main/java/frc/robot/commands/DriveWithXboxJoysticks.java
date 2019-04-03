package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import frc.robot.RobotMap;


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
		if(Robot.oi.getXboxDriveRB() == true){
			Robot.driveTrain.tankDrive(-Robot.oi.getLeftXboxJoystickValue()*0.5 + -Robot.oi.getLeftXboxJoystickValue()*0.5*Math.pow(Math.abs(-Robot.oi.getLeftXboxJoystickValue()), 2) * 0.75, -Robot.oi.getRightXboxJoystickValue()*0.5 + -Robot.oi.getRightXboxJoystickValue()*0.5*Math.pow(Math.abs(Robot.oi.getRightXboxJoystickValue()),2)* 0.75);	
		}
		if(Robot.oi.getXboxDriveLB() == true){
			Robot.driveTrain.tankDrive(-Robot.oi.getLeftXboxJoystickValue()*0.5 + -Robot.oi.getLeftXboxJoystickValue()*0.5*Math.pow(Math.abs(-Robot.oi.getLeftXboxJoystickValue()), 2) * 0.6, -Robot.oi.getRightXboxJoystickValue()*0.5 + -Robot.oi.getRightXboxJoystickValue()*0.5*Math.pow(Math.abs(Robot.oi.getRightXboxJoystickValue()),2) * 0.6);
		}

		else{
			Robot.driveTrain.tankDrive(-Robot.oi.getLeftXboxJoystickValue()*0.5 + -Robot.oi.getLeftXboxJoystickValue()*0.5*Math.pow(Math.abs(-Robot.oi.getLeftXboxJoystickValue()), 2), -Robot.oi.getRightXboxJoystickValue()*0.5 + -Robot.oi.getRightXboxJoystickValue()*0.5*Math.pow(Math.abs(Robot.oi.getRightXboxJoystickValue()),2));	
		}
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