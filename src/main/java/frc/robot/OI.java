package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.AutoLift;
import frc.robot.commands.AutoWrist;
import frc.robot.commands.MoveSweeper;
import frc.robot.commands.MoveSweeper2;
import frc.robot.commands.SweeperDeploy;
import edu.wpi.first.wpilibj.GenericHID.Hand;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Driver's Xbox Controller
	private XboxController xboxDrive;
	//private Button xboxDriveB;
	//private Button xboxDriveStart;
	/*private Button xboxDriveA;
	
	private Button xboxDriveX;
	private Button xboxDriveY;
	private Button xboxDriveRB;
	private Button xboxDriveLB;
	private Button xboxDriveBack;
	*/
	
	private XboxController xboxManipulate;
	private Button xboxManipulateLB;
	private Button xboxManipulateX;
	private Button xboxManipulateY;
	private Button xboxManipulateRB;
	private Button xboxManipulateA;
	private Button xboxManipulateB;
	//private Button xboxManipulateLT;
	//private Button xboxManipulateRT;
	private Button xboxManipulateShare;
	private Button xboxManipulateOptions;
	//private Button xboxManipulateSR;
	
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
		


		//xboxDriveStart = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_BS);

		//xboxDriveB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_B);	
		//this is a new comment
		// Manipulator Xbox Controller Bindings
		xboxManipulate = new XboxController(RobotMap.XBOX_MANIPULATE); 

		//lift
		xboxManipulateA = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_A);
		if(Robot.oi.getXboxManipulateLT() > 0.01){
		xboxManipulateA.whenPressed(new AutoLift (RobotMap.LIFT_BALL_PICKUP));
		}
		if(Robot.oi.getXboxManipulateRT() > 0.01){
			xboxManipulateA.whenPressed(new AutoLift (RobotMap.LIFT_GROUND));
		}	
		xboxManipulateB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_B);
		if(Robot.oi.getXboxManipulateLT() > 0.01){
		xboxManipulateB.whenPressed(new AutoLift (RobotMap.LIFT_BALL1));
		}
		if(Robot.oi.getXboxManipulateRT() > 0.01){
		xboxManipulateB.whenPressed(new AutoLift (RobotMap.LIFT_GROUND));
		}	
		xboxManipulateX = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_X);
		if(Robot.oi.getXboxManipulateLT() > 0.01){
		xboxManipulateX.whenPressed(new AutoLift (RobotMap.LIFT_BALL2));
		}
		if(Robot.oi.getXboxManipulateRT() > 0.01){
		xboxManipulateX.whenPressed(new AutoLift (RobotMap.LIFT_HATCH2));
		}	
		xboxManipulateY = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_Y);
		if(Robot.oi.getXboxManipulateLT() > 0.01){		
		xboxManipulateY.whenPressed(new AutoLift (RobotMap.LIFT_BALL3));
		}
		if(Robot.oi.getXboxManipulateRT() > 0.01){
		xboxManipulateY.whenPressed(new AutoLift (RobotMap.LIFT_HATCH3));
		}	
		xboxManipulateRB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_RB);
		xboxManipulateRB.whenPressed(new AutoWrist(RobotMap.INTAKE_WRIST_PACKAGED));

		xboxManipulateLB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_LB);
		xboxManipulateLB.whenPressed(new AutoWrist(RobotMap.INTAKE_WRIST_GROUND_INTAKE_BALL));

		xboxManipulateLB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_LB);
		xboxManipulateLB.whenPressed(new SweeperDeploy());

		xboxManipulateShare = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_SHARE);
		xboxManipulateShare.whenPressed(new MoveSweeper(RobotMap.SWEEPER_PACKAGED)); //packaged

		xboxManipulateOptions = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_OPTIONS);
		xboxManipulateOptions.whenPressed(new MoveSweeper2(RobotMap.SWEEPER_DEPLOYED)); //deployed


		//xboxManipulateShare = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_SHARE);
		//xboxManipulateShare.whileHeld(new AutoLift (RobotMap.LIFT_HATCH3));


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
		rightAxis = xboxManipulate.getY(Hand.kRight);
		// Allow for up to 10% of joystick noise
		rightAxis = (Math.abs(rightAxis) < 0.1) ? 0 : rightAxis;
    	return rightAxis;
	}
	
	
	public double getXboxManipulateLT() {
		double leftAxis;
		leftAxis = xboxManipulate.getRawAxis(RobotMap.XBOX_MANIPULATE_LT);
		// Allow for up to 10% of joystick noise
		leftAxis = (Math.abs(leftAxis) < 0.1) ? 0 : leftAxis;
    	return leftAxis;
	}

	public double getXboxManipulateRT() {
		double rightAxis;
		rightAxis = xboxManipulate.getRawAxis(RobotMap.XBOX_MANIPULATE_RT);
		// Allow for up to 10% of joystick noise
		rightAxis = (Math.abs(rightAxis) < 0.1) ? 0 : rightAxis;
    	return rightAxis;
	}


}