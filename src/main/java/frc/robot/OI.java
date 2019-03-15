package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.commands.AutoLiftLB;
import frc.robot.commands.AutoLiftRB;
import frc.robot.commands.AutoWrist;
import frc.robot.commands.EndGameBackWheelsIn;
import frc.robot.commands.EndGameBackWheelsMove;
import frc.robot.commands.EndGameBackWheelsMoveReverse;
import frc.robot.commands.EndGameFrontWheelsIn;
import frc.robot.commands.EndGameSetPosition;
import frc.robot.commands.Hatchy;
import frc.robot.commands.SweeperDeployIntake;
import frc.robot.commands.SweeperPackageIntake;
import edu.wpi.first.wpilibj.GenericHID.Hand;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Driver's Xbox Controller
	private XboxController xboxDrive;
	private POVButton xboxDrivePOVUp;
	private POVButton xboxDrivePOVDown;
	private POVButton xboxDrivePOVLeft;
	private POVButton xboxDrivePOVRight;
	//private Button xboxDriveStart;
	private Button xboxDriveSelect;

	private XboxController xboxManipulate;
	private Button xboxManipulateLB;
	private Button xboxManipulateX;
	private Button xboxManipulateY;
	private Button xboxManipulateRB;
	private Button xboxManipulateA;
	private Button xboxManipulateB;
	private Button xboxManipulateSL;
	private Button xboxManipulateSR;
	//private Button xboxManipulateLT;
	//private Button xboxManipulateRT;
	private Button xboxManipulateShare;
	private Button xboxManipulateStart;
	private POVButton xboxManipulatorPOVUp;
	private POVButton xboxManipulatorPOVLeft;
	private POVButton xboxManipulatorPOVRight;
	private POVButton xboxManipulatorPOVDown;
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

		xboxDrivePOVLeft = new POVButton(xboxDrive, RobotMap.XBOX_DRIVE_POV_LEFT);
		xboxDrivePOVLeft.whenPressed(new EndGameSetPosition());

		xboxDrivePOVDown = new POVButton(xboxDrive, RobotMap.XBOX_DRIVE_POV_DOWN);
		xboxDrivePOVDown.whileHeld(new EndGameBackWheelsMove());

		xboxDrivePOVUp = new POVButton(xboxDrive, RobotMap.XBOX_DRIVE_POV_UP);
 		xboxDrivePOVUp.whenPressed(new EndGameFrontWheelsIn());
		
		xboxDrivePOVRight = new POVButton(xboxDrive, RobotMap.XBOX_DRIVE_POV_RIGHT);
		xboxDrivePOVRight.whenPressed(new EndGameBackWheelsIn());

		xboxDriveSelect = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_SHARE);
		xboxDriveSelect.whenPressed(new EndGameBackWheelsMoveReverse());

		xboxManipulateShare = new JoystickButton(xboxDrive, RobotMap.XBOX_MANIPULATE_SHARE);
		//xboxManipulateShare.whileHeld(new AutoWrist(RobotMap.INTAKE_WRIST_PACKAGED));
		//lift
		xboxManipulateA = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_A);
		//xboxManipulateA.whenPressed(new AutoLift (RobotMap.LIFT_BALL_PICKUP));
	
		xboxManipulateB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_B);
		//xboxManipulateB.whenPressed(new AutoLift (RobotMap.LIFT_BALL1));

		xboxManipulateX = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_X);
		//xboxManipulateX.whenPressed(new AutoLift (RobotMap.LIFT_BALL2));

		xboxManipulateY = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_Y);
		//xboxManipulateY.whenPressed(new AutoLift (RobotMap.LIFT_BALL3));
		

		xboxManipulateRB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_RB);
		xboxManipulateRB.whileHeld(new AutoLiftRB());

		xboxManipulateLB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_LB);
		xboxManipulateLB.whileHeld(new AutoLiftLB());
		//end lift here

		// WRIST BUTTONS HERE

		xboxManipulatorPOVLeft = new POVButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_POV_LEFT);
		xboxManipulatorPOVLeft.whenPressed(new AutoWrist(RobotMap.INTAKE_WRIST_CARGO_STATION_INTAKE));

		xboxManipulatorPOVDown = new POVButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_POV_DOWN);
		xboxManipulatorPOVDown.whenPressed(new AutoWrist(RobotMap.INTAKE_WRIST_GROUND_INTAKE));

		xboxManipulatorPOVUp = new POVButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_POV_UP);
		xboxManipulatorPOVUp.whenPressed(new AutoWrist(RobotMap.INTAKE_WRIST_HATCH_POSITION));
		
		xboxManipulatorPOVRight = new POVButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_POV_RIGHT);
		xboxManipulatorPOVRight.whenPressed(new AutoWrist(RobotMap.INTAKE_WRIST_CARGO_OUTPUT));

		xboxManipulateShare = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_SHARE);
		xboxManipulateShare.whileHeld(new AutoWrist(RobotMap.INTAKE_WRIST_PACKAGED));

		//SWEEPER BUTTON
		// Setup the left joystick of the manipulate controller to deploy the sweeper
		// when the button click (pushed down) is activated.
		xboxManipulateSL = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_SL);
		xboxManipulateSL.whenPressed(new SweeperDeployIntake());

		// Setup the Right joystick of the manipulate controller to package the sweeper
		// when the button click (pushed down) is activated.
		xboxManipulateSR = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_SR);
		xboxManipulateSR.whenPressed(new SweeperPackageIntake());

		xboxManipulateStart = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_OPTIONS);
		xboxManipulateStart.whenPressed(new Hatchy());
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

	public boolean getXboxManipulateA() {
		boolean buttonPressed = false;
		if(xboxManipulateA.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

	public boolean getXboxManipulateY() {
		boolean buttonPressed = false;
		if(xboxManipulateY.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

	public boolean getXboxManipulateB() {
		boolean buttonPressed = false;
		if(xboxManipulateB.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

	public boolean getXboxManipulateX() {
		boolean buttonPressed = false;
		if(xboxManipulateX.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

	public boolean getXboxManipulateRB() {
		boolean buttonPressed = false;
		if(xboxManipulateRB.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

	public boolean getXboxManipulateLB() {
		boolean buttonPressed = false;
		if(xboxManipulateLB.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}


}