package frc.robot;



import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.commands.MatchStart;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;

/*import org.usfirst.frc.team68.robot.auto.RightAutoStartCommand; */

public class Robot extends TimedRobot {
	
	

	public static RobotMap robotMap;

	public static Wrist wrist;

	public static OI oi;

	public static DriveTrain driveTrain;

	public static Lift lift;

	public static Intake intake;

	public static Sweeper sweeper;

	public static UsbCamera camera;

	public static Hatch hatch;

	public static EndGame endGame;


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
		sweeper = Sweeper.getSweeper();
		hatch = Hatch.getHatch();
		endGame = EndGame.getEndGame();

		new Thread(() -> {
			UsbCamera camera0 = CameraServer.getInstance().startAutomaticCapture(0);
			camera0.setResolution(480, 320);

			CvSink cvSink = CameraServer.getInstance().getVideo();
			CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 480, 320);

			Mat source = new Mat();
			Mat output = new Mat();

			while(!Thread.interrupted()){
				cvSink.grabFrame(source);
				Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
				outputStream.putFrame(output);
			}

		}).start();
		
		//UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(1);
		
		// The OI class should be the last to be instantiated

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

		if (autonomousCommand != null)
	        //System.out.println("Auto Running: " + autonomousCommand.getName());
			autonomousCommand.start();

			Robot.driveTrain.setBrakeMode();
			Robot.lift.zeroEncoder();
			Robot.sweeper.zeroEncoder();
			Robot.wrist.zeroEncoder();
			Robot.endGame.zeroEncoder();
 
			Scheduler.getInstance().add(new MatchStart());
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {

		Scheduler.getInstance().run();

		/*SmartDashboard.putNumber("encoder value lift", Robot.lift.getPosition());
		SmartDashboard.putNumber("encoder value sweeper wrist", Robot.sweeper.getPosition());
		SmartDashboard.putNumber("encoder value claw wrist", Robot.wrist.getPosition());
		SmartDashboard.putNumber("Endgame Back Right encoder POS", Robot.endGame.getBackRightMotorPos());
		SmartDashboard.putNumber("Endgame Back Left encoder POS", Robot.endGame.getBackLeftMotorPos());
		SmartDashboard.putNumber("Endgame Front Left encoder POS", Robot.endGame.getFrontLeftMotorPos());
		SmartDashboard.putNumber("Endgame Front Right encoder POS", Robot.endGame.getFrontRightMotorPos());4
		*/
		SmartDashboard.putNumber("encoder value sweeper wrist", Robot.sweeper.getPosition());

		SmartDashboard.putNumber("Endgame Ultrasonic Back", Robot.endGame.getUltraSonicVoltBack());
		SmartDashboard.putNumber("Endgame UltraSonic Front", Robot.endGame.getUltraSonicVoltFront());
		
		SmartDashboard.putBoolean("Wrist Cargostation", Robot.wrist.isWristCargoStationPos());
		SmartDashboard.putBoolean("Wrist Ground intake", Robot.wrist.isWristGroundIntakePos());
		SmartDashboard.putBoolean("wrist hatch pos", Robot.wrist.isWristHatchPos());
		SmartDashboard.putBoolean("Wrist Packaged", Robot.wrist.isWristPackaged());
		SmartDashboard.putBoolean("Wrist Output Pos", Robot.wrist.isWristOutputPos());

		SmartDashboard.putBoolean("BEAM BREAK", Robot.intake.getBeamBreak());
		SmartDashboard.putBoolean("IS DEPLOYED", Robot.sweeper.isDeployed());
		SmartDashboard.putBoolean("Is Ground", Robot.endGame.isGroundBack());
		SmartDashboard.putBoolean("Is Ground Front", Robot.endGame.isGroundFront());
		SmartDashboard.putBoolean("IS HATCH OUT", Robot.hatch.getLimitSwitch());


	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();

			Robot.endGame.zeroEncoder();
			
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		/*
		SmartDashboard.putNumber("encoder value lift", Robot.lift.getPosition());
		SmartDashboard.putNumber("encoder value sweeper wrist", Robot.sweeper.getPosition());
		SmartDashboard.putNumber("encoder value claw wrist", Robot.wrist.getPosition());
		SmartDashboard.putNumber("Endgame Back Right encoder POS", Robot.endGame.getBackRightMotorPos());
		SmartDashboard.putNumber("Endgame Back Left encoder POS", Robot.endGame.getBackLeftMotorPos());
		SmartDashboard.putNumber("Endgame Front Left encoder POS", Robot.endGame.getFrontLeftMotorPos());
		SmartDashboard.putNumber("Endgame Front Right encoder POS", Robot.endGame.getFrontRightMotorPos());
		*/
		SmartDashboard.putBoolean("Wrist Cargostation", Robot.wrist.isWristCargoStationPos());
		SmartDashboard.putBoolean("Wrist Ground intake", Robot.wrist.isWristGroundIntakePos());
		SmartDashboard.putBoolean("wrist hatch pos", Robot.wrist.isWristHatchPos());
		SmartDashboard.putBoolean("Wrist Packaged", Robot.wrist.isWristPackaged());
		SmartDashboard.putBoolean("Wrist Output Pos", Robot.wrist.isWristOutputPos());

	//	SmartDashboard.putNumber("Endgame Ultrasonic", Robot.endGame.getUltraSonicVoltBack());
	//	SmartDashboard.putNumber("Endgame UltraSonic Front", Robot.endGame.getUltraSonicVoltFront());

		SmartDashboard.putBoolean("BEAM BREAK", Robot.intake.getBeamBreak());
		SmartDashboard.putBoolean("IS DEPLOYED", Robot.sweeper.isDeployed());
		SmartDashboard.putBoolean("Is Ground", Robot.endGame.isGroundBack());
		SmartDashboard.putBoolean("Is Ground Front", Robot.endGame.isGroundFront());
		SmartDashboard.putBoolean("IS HATCH OUT", Robot.hatch.getLimitSwitch());
		SmartDashboard.putNumber("Endgame Ultrasonic Back", Robot.endGame.getUltraSonicVoltBack());
		SmartDashboard.putNumber("Endgame UltraSonic Front", Robot.endGame.getUltraSonicVoltFront());

	}


	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	//	LiveWindow.run();
	}

} 