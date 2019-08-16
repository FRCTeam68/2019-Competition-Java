package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
import frc.robot.commands.DriveWithXboxJoysticks;

import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;



public class DriveTrain extends Subsystem {
	


	private boolean reverseDrive;

	private CANSparkMax leftFront;
	private CANSparkMax rightFront;
	private CANSparkMax leftBack;
	private CANSparkMax rightBack;

	StringBuilder reportPIDLeft = new StringBuilder();
	StringBuilder reportPIDRight = new StringBuilder();
	
	public static DriveTrain driveTrain;

	public static DriveTrain getDriveTrain() {
		if (driveTrain == null) {
			driveTrain = new DriveTrain();
		}
		return driveTrain;
	}

	private DriveTrain() {


		//jake 

		leftBack = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_REAR,MotorType.kBrushless);

		rightBack = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_REAR,MotorType.kBrushless);

		leftFront = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_FRONT,MotorType.kBrushless);

		rightFront = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_FRONT,MotorType.kBrushless);

		//vars for LB
		leftBack.setSmartCurrentLimit(40);
		leftBack.setSecondaryCurrentLimit(40);
		//vars for RB
		rightBack.setSmartCurrentLimit(40);
		rightBack.setSecondaryCurrentLimit(40);
		//vars for LF
		leftFront.setSmartCurrentLimit(40);
		leftFront.setSecondaryCurrentLimit(40);
		//vars for RF
		rightFront.setSmartCurrentLimit(40);
		rightFront.setSecondaryCurrentLimit(40);

	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithXboxJoysticks());
	}
	
    public boolean getDriveOrientation() {
    	return reverseDrive;
    }
    
    public void setDriveOrientation() {
    	// Reverse the current drive orientation
    	reverseDrive = !reverseDrive;
    	// update the dashboard to reflect the current drive orientation
    	//SmartDashboard.putBoolean("Drive Orientation: ", reverseDrive);
    }
    
    public void zeroEncoders(){
		//Robot.navX.navX.zeroYaw();

	}
	public void setSpeedleft(){
		
	}


    public void tankDrive(double leftSpeed, double rightSpeed) {
    	rightFront.set(rightSpeed);
		rightBack.set(rightSpeed);
		leftFront.set(leftSpeed);
		leftBack.set(leftSpeed);
	}

}