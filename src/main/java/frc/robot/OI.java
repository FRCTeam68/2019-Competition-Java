package frc.robot;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.commands.AutoLiftLB;
import frc.robot.commands.AutoLiftRB;
import frc.robot.commands.AutoWrist;
import frc.robot.commands.EndGameMotors;
import frc.robot.commands.EndGameSequenceLevel2;
import frc.robot.commands.EndGameWheelsMove;
import frc.robot.commands.EndGameWheelsMoveBack;
import frc.robot.commands.EndGameWheelsStop;
import frc.robot.commands.RunForwardBack;
import frc.robot.commands.RunForwardDrive;
//import frc.robot.commands.StartSequenceLevel2;
//import frc.robot.commands.FeedStationCargo;
import frc.robot.commands.SweeperDeployIntake;
import frc.robot.commands.SweeperPackage;
import frc.robot.commands.SweeperPackageIntake;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;


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
	private Button xboxDriveRB;
	private Button xboxDriveLB;
	private Button xboxDriveRTButton;
	private Button xboxDriveLTButton;
	private Button xboxDriveTriangle;
	private Button xboxDriveCircle;
	private Button xboxDriveSquare;
	private Button xboxDriveX;
	private Button xboxDriveStart;
	private Button xboxDriveSL;
	private Button xboxDriveSR;
	//private Button xboxDriveSelect;

	private XboxController xboxManipulate;
	private Button xboxManipulateLB;
	private Button xboxManipulateSquare;
	private Button xboxManipulateTriangle;
	private Button xboxManipulateRB;
	private Button xboxManipulateX;
	private Button xboxManipulateCircle;
	private Button xboxManipulateSL;
	private Button xboxManipulateSR;
	private Button xboxManipulateLT;
	private Button xboxManipulateRT;
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
		
		xboxDriveRB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_RB);

		xboxDriveLB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_LB);

		xboxDriveRTButton = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_RT_BUTTON);
		xboxDriveRTButton.whenPressed(new EndGameWheelsMove(1));

		xboxDriveRTButton.whenReleased(new EndGameWheelsStop());

		xboxDriveLTButton = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_LT_BUTTON);
		xboxDriveLTButton.whenPressed(new EndGameWheelsMoveBack());

		xboxDriveLTButton.whenReleased(new EndGameWheelsStop());

	//	xboxDriveSelect = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_SHARE);
	//	xboxDriveSelect.whenPressed(new StartSequenceLevel2());

		xboxDrivePOVRight = new POVButton(xboxDrive, RobotMap.XBOX_DRIVE_POV_RIGHT);
		xboxDrivePOVRight.whenPressed(new EndGameMotors(RobotMap.ENDGAME_FRONT_LIFTED_POSIITON,RobotMap.ENDGAME_ZERO));

		xboxDrivePOVDown = new POVButton(xboxDrive, RobotMap.XBOX_DRIVE_POV_DOWN);
		xboxDrivePOVDown.whenPressed(new EndGameMotors(RobotMap.ENDGAME_ZERO, RobotMap.ENDGAME_ZERO));


		xboxDrivePOVUp = new POVButton(xboxDrive, RobotMap.XBOX_DRIVE_POV_UP);
		xboxDrivePOVUp.whenPressed(new EndGameSequenceLevel2());

		xboxDrivePOVLeft = new POVButton(xboxDrive, RobotMap.XBOX_DRIVE_POV_LEFT);

		xboxDriveTriangle = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_TRIANGLE);
		xboxDriveTriangle.whenPressed(new EndGameMotors(RobotMap.ENDGAME_FRONT_HEIGHT_UP,RobotMap.ENDGAME_BACK_HEIGHT_UP));

		xboxDriveCircle = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_CIRCLE);
		xboxDriveCircle.whenPressed(new EndGameMotors(RobotMap.ENDGAME_FRONT_HEIGHT_UP,RobotMap.ENDGAME_ZERO));

		xboxDriveStart = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_OPTIONS);
		xboxDriveStart.whenPressed(new EndGameMotors(RobotMap.ENDGAME_FRONT_LVL2_LVL3,RobotMap.ENDGAME_BACK_LVL2_LVL3));

		xboxDriveSquare = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_SQUARE);
		xboxDriveSquare.whenPressed(new EndGameMotors(RobotMap.ENDGAME_FRONT_LVL2_LVL3,RobotMap.ENDGAME_ZERO));

		xboxDriveX = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_X);
		xboxDriveX.whenPressed(new EndGameMotors(RobotMap.ENDGAME_ZERO,RobotMap.ENDGAME_ZERO));

		xboxDriveSL = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_SL);
		xboxDriveSL.whileHeld(new RunForwardBack());

		xboxDriveSR = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_SR);
		xboxDriveSR.whileHeld(new RunForwardDrive());


	
		//LIFT
		


		//xboxDriveStart = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_BS);

		//xboxDriveB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_B);	
		//this is a new comment
		// Manipulator Xbox Controller Bindings
		xboxManipulate = new XboxController(RobotMap.XBOX_MANIPULATE); 

		 
		xboxManipulateShare = new JoystickButton(xboxDrive, RobotMap.XBOX_MANIPULATE_SHARE);
		//xboxManipulateShare.whileHeld(new AutoWrist(RobotMap.INTAKE_WRIST_PACKAGED));
		//lift
		xboxManipulateX = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_X);
		//xboxManipulateA.whenPressed(new AutoLift (RobotMap.LIFT_BALL_PICKUP));
	
		xboxManipulateCircle = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_CIRCLE);
		//xboxManipulateB.whenPressed(new AutoLift (RobotMap.LIFT_BALL1));

		xboxManipulateSquare = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_SQUARE);
		//xboxManipulateX.whenPressed(new AutoLift (RobotMap.LIFT_BALL2));

		xboxManipulateTriangle = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_TRIANGLE);
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
		xboxManipulateShare.whenPressed(new AutoWrist(RobotMap.INTAKE_WRIST_PACKAGED));

		//SWEEPER BUTTON
		xboxManipulateStart = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_OPTIONS);
		xboxManipulateStart.whenPressed(new SweeperPackage());

		// Setup the left joystick of the manipulate controller to deploy the sweeper
		// when the button click (pushed down) is activated.
		xboxManipulateSL = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_SL);
		xboxManipulateSL.whenPressed(new SweeperPackageIntake());

		// Setup the Right joystick of the manipulate controller to package the sweeper
		// when the button click (pushed down) is activated.
		xboxManipulateSR = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_SR);
		xboxManipulateSR.whenPressed(new SweeperDeployIntake());

		
		//xboxManipulateShare = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_SHARE);
		//xboxManipulateShare.whileHeld(new AutoLift (RobotMap.LIFT_HATCH3));

		xboxManipulateLT = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_LT);
		xboxManipulateLT.whileHeld(new AutoLiftLB());

		xboxManipulateRT = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_RT);
		xboxManipulateRT.whileHeld(new AutoLiftRB());

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

	public double getXboxDriveLT() {
		double leftAxis;
		leftAxis = xboxDrive.getRawAxis(RobotMap.XBOX_DRIVE_LT);
		// Allow for up to 10% of joystick noise
		leftAxis = (Math.abs(leftAxis) < 0.1) ? 0 : leftAxis;
    	return leftAxis;
	}

	public double getXboxDriveRT() {
		double rightAxis;
		rightAxis = xboxDrive.getRawAxis(RobotMap.XBOX_DRIVE_RT);
		// Allow for up to 10% of joystick noise
		rightAxis = (Math.abs(rightAxis) < 0.1) ? 0 : rightAxis;
    	return rightAxis;
	}

	public boolean getXboxManipulateX() {
		boolean buttonPressed = false;
		if(xboxManipulateX.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

	public boolean getXboxManipulateTriangle() {
		boolean buttonPressed = false;
		if(xboxManipulateTriangle.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

	public boolean getXboxManipulateCircle() {
		boolean buttonPressed = false;
		if(xboxManipulateCircle.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

	public boolean getXboxManipulateSquare() {
		boolean buttonPressed = false;
		if(xboxManipulateSquare.get()){
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

	public boolean getXboxManipulateLTButton() {
		boolean buttonPressed = false;
		if(xboxManipulateLT.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

	public boolean getXboxManipulateRTButton() {
		boolean buttonPressed = false;
		if(xboxManipulateRT.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

	public void xboxManipulateRumbleStart(){
		xboxManipulate.setRumble(RumbleType.kLeftRumble,.25);
		xboxManipulate.setRumble(RumbleType.kRightRumble,.25);
	}
	public void xboxManipulateRumbleStop(){
		xboxManipulate.setRumble(RumbleType.kLeftRumble,0);
		xboxManipulate.setRumble(RumbleType.kRightRumble,0);
	}
	public boolean getXboxDriveRB() {
		boolean buttonPressed = false;
		if(xboxDriveRB.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

	public boolean getXboxDriveLB() {
		boolean buttonPressed = false;
		if(xboxDriveLB.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

	public boolean getXboxDrivePOVUp() {
		boolean buttonPressed = false;
		if(xboxDrivePOVUp.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}
	public boolean getXboxDrivePOVLeft() {
		boolean buttonPressed = false;
		if(xboxDrivePOVLeft.get()){
			buttonPressed = true;
		}
		return buttonPressed;
	}

}