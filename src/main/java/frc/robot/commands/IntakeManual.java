
package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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

		joystickSpeed = Robot.oi.getLeftXboxManipulatorJoystick();
		if(Math.abs(joystickSpeed) > .5) { // it better be intentional 
			if(!Robot.sweeper.isDeployed()) {
				// Notify the drivers the sweeper IS NOT deployed
				SmartDashboard.putBoolean("Sweeper State", false);
				if(joystickSpeed < -0.5) {
					System.out.println("Setting intake speed to " + joystickSpeed);
					Robot.intake.setIntakeSpeed(joystickSpeed);
				}
			} else {
				// Notify the drivers the sweeper IS 
				SmartDashboard.putBoolean("Sweeper State", true);
				if(joystickSpeed > 0.5) {    // Intaking
					if(!Robot.intake.getBeamBreak()) {
						System.out.println("Beam Break is FALSE ");
						System.out.println("Setting intake speed to " + joystickSpeed);
						Robot.intake.setIntakeSpeed(joystickSpeed);
						System.out.println("Setting sweeper speed to " + joystickSpeed);
						Robot.sweeper.setSweeperSpeed(joystickSpeed);
					} else if (Robot.intake.getBeamBreak()) {  // the beam is broken
						System.out.println("BEAM Broken");
						Robot.intake.setIntakeSpeed(RobotMap.MOTOR_STOP);
						Robot.sweeper.setSweeperSpeed(RobotMap.MOTOR_STOP);
						Scheduler.getInstance().add(new DeliverCargo());
					}
				}
			}
		} else {
			Robot.intake.setIntakeSpeed(RobotMap.MOTOR_STOP);
			Robot.sweeper.setSweeperSpeed(RobotMap.MOTOR_STOP);
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
