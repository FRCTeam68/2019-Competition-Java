package frc.robot;

//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.CameraServer;
//import edu.wpi.cscore.UsbCamera;
//import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.Compressor;

import frc.robot.commands.IntakeManualXboxJoysticks;
//import frc.robot.commands.LiftManual;
/*import frc.robot.auto.RightAutoStartCommand; */
//import frc.robot.subsystems.Compressor;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.NavX;
//import frc.robot.subsystems.Vision;
import frc.robot.subsystems.EndGame;

public class Robot extends TimedRobot {
	
	public static RobotMap robotMap;
	public static Compressor compressor;
	public static DriveTrain driveTrain;
	public static Lift lift;
	public static Intake intake;
	public static OI oi;
	public static NavX navX;
	public static EndGame endGame;
	//public static Vision vision;


	Command autonomousCommand;
	SendableChooser<Command> autoChooser;
	SendableChooser<String> stratChooser;
 
	/**	
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// The RobotMap class should be the first to instantiate
		robotMap = RobotMap.getRobotMap();
		
		// Create a single instance of each Robot subsystem here
		compressor = new Compressor(RobotMap.PCM_MAIN);
		navX = new NavX();
		driveTrain = DriveTrain.getDriveTrain();   
		lift = Lift.getLift();
        intake = Intake.getIntake();
		endGame = EndGame.getEndGame();
		//vision = Vision.getVision();
		//UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		//camera.setResolution(160, 120);
		//camera.setFPS(10);
		
		//camera.setVideoMode(VideoMode.PixelFormat.kYUYV, 640, 480, 30);
	 
		Robot.compressor.start();
				
		// The OI class should be the last to be instantiated
		
		/*autoChooser = new SendableChooser<>();
	    autoChooser.addObject("Center Start Auto", centerAuto);
	    autoChooser.addObject("Drive Straight", driveStraight);
	    autoChooser.addObject("Left Start Auto", leftAuto);
	    autoChooser.addObject("Right Start Auto", rightAuto);
	    autoChooser.addDefault("Center Start Auto", centerAuto); */



	    //Choosing strategy
	    //Robot.intake.intakeUpPosition();
	    Robot.driveTrain.setShifterHigh();
	    stratChooser = new SendableChooser<>();
	    //stratChooser.addObject("SW", "SW");
	    //stratChooser.addObject("SC/SC", "SC/SC");
	    //stratChooser.addObject("SC", "SC");
	    //stratChooser.addDefault("SC/SW", "SC/SW");
	    SmartDashboard.putData("Autonomous", autoChooser);
	    SmartDashboard.putData("Strat Chooser", stratChooser);
		oi = OI.getOI();

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		Robot.intake.intakeNormal();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();

	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Robot.compressor.stop();
		Robot.driveTrain.clearOpenRamp();
		Robot.driveTrain.zeroEncoders();
		Robot.driveTrain.normalDrivetrain();
		Robot.driveTrain.setShifterHigh();
		//Robot.intake.intakeUpPosition();

        //Command position = autoChooser.getSelected();
    
        /* if (position == centerAuto){
        	centerAuto.PutStrat(stratChooser.getSelected());
            centerAuto.selectAuto();
        }
        
        if (position == leftAuto){
        	leftAuto.PutStrat(stratChooser.getSelected());
            leftAuto.selectAuto();
        }
        
        if (position == rightAuto){
        	rightAuto.PutStrat(stratChooser.getSelected());
            rightAuto.selectAuto();
        }
        
        if (position == driveStraight){
            driveStraight.selectAuto();
        } */
        
		autonomousCommand = autoChooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
		
		if (autonomousCommand != null)
	        System.out.println("Auto Running: " + autonomousCommand.getName());
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro Angle", Robot.navX.getAngle());
	}

	@Override
	public void teleopInit() {
		Robot.compressor.start();
		Robot.driveTrain.clearOpenRamp();
		Robot.driveTrain.setCoastMode();
		Robot.driveTrain.setModePercentVbus();
    	Robot.driveTrain.setShifterHigh();
    	Robot.driveTrain.zeroEncoders();
    	Robot.driveTrain.normalDrivetrain();
    	if (Robot.lift.getSwitchDown() == false) {
    		Robot.lift.zeroEncoder();
    	}
    	Robot.intake.setDefaultCommand(new IntakeManualXboxJoysticks());
    	
    	Robot.intake.intakeUpPosition();
    	Robot.intake.intakeNormal();
    	Robot.lift.setPosition(RobotMap.LIFT_GROUND);

		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Lift Encoder Position", Robot.lift.getPosition());
		SmartDashboard.putBoolean("LiftSwitchDown", Robot.lift.getSwitchDown());
		SmartDashboard.putBoolean("LiftManual", Robot.lift.getManualStatus());
		SmartDashboard.putBoolean("Limit Switch Boolean", Robot.intake.getSwitch());
		SmartDashboard.putNumber("RightStick", Robot.oi.getRightXboxManipulatorJoystick());
		SmartDashboard.putBoolean("Clamped", Robot.intake.isClamped());
		//MWE
    	if (Robot.lift.getSwitchDown() == false) {
    		Robot.lift.zeroEncoder();
    	}
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}

} 
 