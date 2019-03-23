package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;


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
		if(Robot.lift.getLastSetPoint() >= RobotMap.LIFT_ROCKET_CARGO_MID - 2000){
			Robot.driveTrain.tankDrive(-Robot.oi.getLeftXboxJoystickValue()*Math.abs(Robot.oi.getLeftXboxJoystickValue()), -Robot.oi.getRightXboxJoystickValue()*Math.abs(Robot.oi.getRightXboxJoystickValue()*Math.abs(Robot.oi.getRightXboxJoystickValue())));	
		}else if(Robot.lift.getLastSetPoint() <= RobotMap.LIFT_ROCKET_CARGO_MID - 2000){
			Robot.driveTrain.tankDrive(-Robot.oi.getLeftXboxJoystickValue()*Math.abs(Robot.oi.getLeftXboxJoystickValue())/2, -Robot.oi.getRightXboxJoystickValue()*Math.abs(Robot.oi.getRightXboxJoystickValue()*Math.abs(Robot.oi.getRightXboxJoystickValue()))/2);	
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