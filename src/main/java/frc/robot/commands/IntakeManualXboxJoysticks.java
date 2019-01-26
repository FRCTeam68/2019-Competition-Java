package frc.robot.commands;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;
import frc.robot.RobotMap;


public class IntakeManualXboxJoysticks extends Command {
	
	boolean isFinished = false;
	//private double speedLeft;
	//private double speedRight;
	
	
	public IntakeManualXboxJoysticks() {
		
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		
		
		if (Robot.oi.getRightXboxManipulatorJoystick() > 0.1) {
			Robot.intake.intakeNormal();
			Robot.intake.setIntakeSpeed(-Robot.oi.getRightXboxManipulatorJoystick()/2.5, Robot.oi.getRightXboxManipulatorJoystick()/2.5);
		}
		// MWE - changed min joystick value from -0.1 to -0.4 to prevent accidental intaking
		else if(Robot.oi.getRightXboxManipulatorJoystick() < -0.4) {
			if (Robot.intake.getSwitch() == false) {
				Robot.intake.intakeClamp();
				Robot.intake.setIntakeSpeed(RobotMap.INTAKE_SPEED_STOP, RobotMap.INTAKE_SPEED_STOP);
			}
			else {
				//MWE
				Robot.intake.intakeDownPosition();
				Robot.intake.intakeNormal();
				// end
				Robot.intake.setIntakeSpeed(RobotMap.INTAKE_A_SPEED_FORWARD, RobotMap.INTAKE_B_SPEED_FORWARD);
			}
		}
		
		else {
			Robot.intake.setIntakeSpeed(0, 0);
			// MWE
   			Robot.intake.intakeUpPosition();
   			Robot.intake.intakeClamp();
		}
			
		
/*		if (Robot.oi.getXboxManipulateLT() > 0) {
   			Robot.intake.intakeNormal();
   		} */
   		
   		if (Robot.oi.getXboxManipulateRT() > 0) {
   			Robot.intake.intakeDownPosition();
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


