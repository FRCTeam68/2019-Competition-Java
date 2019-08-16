package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
//import frc.robot.RobotMap;


public class DriveWithXboxJoysticks extends Command {
	
	boolean isFinished = false;	
	double jakeSMDCargo = -54200.0;
	double jakeSMDHatch = -44454.0 ;
	public double rightJoystick;
	public double leftJoystick;

	public DriveWithXboxJoysticks() {
		
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if(!Robot.oi.getXboxDriveLB()){

			rightJoystick = Robot.oi.getRightXboxJoystickValue();
			leftJoystick = Robot.oi.getLeftXboxJoystickValue();

			SmartDashboard.putNumber("Right Joystick Honey", rightJoystick);
			SmartDashboard.putNumber("Left Joystick Honey", leftJoystick);



			Robot.driveTrain.tankDrive(-leftJoystick,rightJoystick);	
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