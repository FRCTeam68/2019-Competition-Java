package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.AutoLift;

import edu.wpi.first.wpilibj.GenericHID.Hand;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Driver's Xbox Controller
	private XboxController xboxDrive;
	private Button xboxDriveA;
	private Button xboxDriveB;
	private Button xboxDriveX;
	private Button xboxDriveY;
	private Button xboxDriveRB;
	private Button xboxDriveLB;
	private Button xboxDriveBack;
	private Button xboxDriveStart;
	
	private XboxController xboxManipulate;
	private Button xboxManipulateLB;
	private Button xboxManipulateX;
	private Button xboxManipulateY;
	private Button xboxManipulateRB;
	private Button xboxManipulateA;
	private Button xboxManipulateB;
	private Button xboxManipulateLT;
	private Button xboxManipulateShare;
	private Button xboxManipulateOptions;
	private Button xboxManipulateSR;
	
	private static OI oi;
	

	public static OI getOI(){
		if (oi == null) {
			oi = new OI();
		}
		return oi;	
	}
	
	
	private OI() {
		
		xboxDrive = new XboxController(RobotMap.XBOX_DRIVE);	
		
		//LIFT
		xboxManipulateA = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_A);
		xboxManipulateA.whileHeld(new AutoLift (RobotMap.LIFT_GROUND));

		xboxManipulateB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_B);
		xboxManipulateB.whileHeld(new AutoLift (RobotMap.LIFT_BALL1));

		xboxManipulateX = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_X);
		xboxManipulateX.whileHeld(new AutoLift (RobotMap.LIFT_BALL2));

		xboxManipulateY = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_Y);
		xboxManipulateY.whileHeld(new AutoLift (RobotMap.LIFT_BALL3));

		xboxManipulateRB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_RB);
		xboxManipulateRB.whileHeld(new AutoLift (RobotMap.LIFT_HATCH1));

		xboxManipulateLB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_LB);
		xboxManipulateLB.whileHeld(new AutoLift (RobotMap.LIFT_HATCH2));

		xboxManipulateShare = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_SHARE);
		xboxManipulateShare.whileHeld(new AutoLift (RobotMap.LIFT_HATCH3));



		xboxDriveStart = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_BS);

		xboxDriveB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_B);	
		//this is a new comment
		// Manipulator Xbox Controller Bindings
		xboxManipulate = new XboxController(RobotMap.XBOX_MANIPULATE); 


	}
	
	// Custom user defined methods should go here
	

	// Drivetrain Tank Drive Left 
	public double getLeftXboxJoystickValue() {
		double leftAxis;
		leftAxis = xboxDrive.getY(Hand.kLeft);
		// Allow for up to 10% of joystick noises
		leftAxis = (Math.abs(leftAxis) < 0.1) ? 0 : leftAxis;
    	return leftAxis;
	}

	// Drivetrain Tank Drive Right
	public double getRightXboxJoystickValue() {
		double rightAxis;
		rightAxis = xboxDrive.getY(Hand.kRight);
		// Allow for up to 10% of joystick noise
		rightAxis = (Math.abs(rightAxis) < 0.1) ? 0 : rightAxis;
    	return rightAxis;
    	
	}
	
	// Manipulator Joystick for Lift
	public double getLeftXboxManipulatorJoystick() {
		double leftAxis;
		leftAxis = xboxManipulate.getY(Hand.kLeft);
		// Allow for up to 10% of joystick noise
		leftAxis = (Math.abs(leftAxis) < 0.1) ? 0 : leftAxis;
    	return leftAxis;
	}

	public double getRightXboxManipulatorJoystick() {
		double rightAxis;
		rightAxis = xboxManipulate.getY(Hand.kLeft);
		// Allow for up to 10% of joystick noise
		rightAxis = (Math.abs(rightAxis) < 0.1) ? 0 : rightAxis;
    	return rightAxis;
	}
	
	//Intake In
	public double getXboxManipulateLT() {
		double leftAxis;
		leftAxis = xboxManipulate.getRawAxis(RobotMap.XBOX_MANIPULATE_LT);
		// Allow for up to 10% of joystick noise
		leftAxis = (Math.abs(leftAxis) < 0.1) ? 0 : leftAxis;
    	return leftAxis;
	}

	
}