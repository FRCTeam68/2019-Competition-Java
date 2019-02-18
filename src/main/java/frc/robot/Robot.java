package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.commands.AutoLift;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.cscore.UsbCamera;

/*import org.usfirst.frc.team68.robot.auto.RightAutoStartCommand; */

public class Robot extends TimedRobot {
	
	public static RobotMap robotMap;

	public static Wrist wrist;

	public static OI oi;

	public static DriveTrain driveTrain;

	public static Lift lift;

	public static Intake intake;

	public static UsbCamera camera;

	

/*    private LeftAutoStartCommand leftAuto;
    private RightAutoStartCommand rightAuto;*/

	
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
		driveTrain = DriveTrain.getDriveTrain();
		intake = Intake.getIntake();
		lift = Lift.getLift();
		wrist = Wrist.getWrist();

		// The OI class should be the last to be instantiated
/*	    autoChooser.addObject("Left Start Auto", leftAuto);
		autoChooser.addObject("Right Start Auto", rightAuto);*/
		//TESTING ENCODER
	    //autoChooser.addDefault("Auto-Run", new DriveXInchesCommand(100, 0.8));
	    //Choosing strategy


		oi = OI.getOI();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		
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
		
		Robot.driveTrain.setBrakeMode();
		double timeout = System.currentTimeMillis();
        
		while((DriverStation.getInstance().getGameSpecificMessage() == null || DriverStation.getInstance().getGameSpecificMessage().equals(""))
                && System.currentTimeMillis() - timeout > 1000) {
            System.out.println("Waiting For FMS Data");
        }


        
		autonomousCommand = autoChooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		//driveTrain.GetLeftFront().enableBrakeMode(true);
		//driveTrain.GetRightFront().enableBrakeMode(true);
		
		//schedule the autonomous command (example)
		if (autonomousCommand != null)
	        System.out.println("Auto Running: " + autonomousCommand.getName());
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void teleopInit() {

		Robot.driveTrain.setBrakeMode();

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
		SmartDashboard.putNumber("encoder value", Robot.lift.getPosition());
	}


	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	//	LiveWindow.run();
	}

} 
 