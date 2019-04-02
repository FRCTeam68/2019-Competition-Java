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
			Robot.driveTrain.tankDrive(-Robot.oi.getLeftXboxJoystickValue()
			*Math.abs(Robot.oi.getLeftXboxJoystickValue())*.75, -Robot.oi.getRightXboxJoystickValue()*Math.abs(Robot.oi.getRightXboxJoystickValue())*.75);	
		}
		if(Robot.oi.getXboxDriveLB() == true){
			Robot.driveTrain.tankDrive(-Robot.oi.getLeftXboxJoystickValue()*Math.abs(Robot.oi.getLeftXboxJoystickValue())*.6, -Robot.oi.getRightXboxJoystickValue()*Math.abs(Robot.oi.getRightXboxJoystickValue())*.6);	
		}

		else{
			Robot.driveTrain.tankDrive(-Robot.oi.getLeftXboxJoystickValue()*Math.abs(Robot.oi.getLeftXboxJoystickValue()), -Robot.oi.getRightXboxJoystickValue()*Math.abs(Robot.oi.getRightXboxJoystickValue()));	
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