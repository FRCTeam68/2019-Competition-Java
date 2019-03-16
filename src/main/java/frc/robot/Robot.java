package frc.robot;


import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.commands.MatchStart;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.UsbCamera;

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

		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(160, 120);
		camera.setFPS(10);

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
	//		Robot.endGame.zeroEncoder();

			Scheduler.getInstance().add(new MatchStart());
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {

		Scheduler.getInstance().run();
		SmartDashboard.putNumber("encoder value lift", Robot.lift.getPosition());
		SmartDashboard.putNumber("encoder value sweeper wrist", Robot.sweeper.getPosition());
		SmartDashboard.putNumber("encoder value claw wrist", Robot.wrist.getPosition());
		SmartDashboard.putNumber("Endgame back encoder POS", Robot.endGame.getBackMotorPos());
		SmartDashboard.putNumber("Endgame Front encoder POS", Robot.endGame.getFrontMotorPos());
		SmartDashboard.putBoolean("Wrist Cargostation", Robot.wrist.isWristCargoStationPos());
		SmartDashboard.putBoolean("Wrist Ground intake", Robot.wrist.isWristGroundIntakePos());
		SmartDashboard.putBoolean("wrist hatch pos", Robot.wrist.isWristHatchPos());
		SmartDashboard.putBoolean("Wrist Packaged", Robot.wrist.isWristPackaged());
		SmartDashboard.putBoolean("Wrist Output Pos", Robot.wrist.isWristOutputPos());
		SmartDashboard.putBoolean("BEAM BREAK", Robot.intake.getBeamBreak());
	}

	@Override
	public void teleopInit() {
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
		SmartDashboard.putNumber("encoder value lift", Robot.lift.getPosition());
		SmartDashboard.putNumber("encoder value sweeper wrist", Robot.sweeper.getPosition());
		SmartDashboard.putNumber("encoder value claw wrist", Robot.wrist.getPosition());
		SmartDashboard.putNumber("Endgame back encoder POS", Robot.endGame.getBackMotorPos());
		SmartDashboard.putNumber("Endgame Front encoder POS", Robot.endGame.getFrontMotorPos());
		SmartDashboard.putBoolean("Wrist Cargostation", Robot.wrist.isWristCargoStationPos());
		SmartDashboard.putBoolean("Wrist Ground intake", Robot.wrist.isWristGroundIntakePos());
		SmartDashboard.putBoolean("wrist hatch pos", Robot.wrist.isWristHatchPos());
		SmartDashboard.putBoolean("Wrist Packaged", Robot.wrist.isWristPackaged());
		SmartDashboard.putBoolean("Wrist Output Pos", Robot.wrist.isWristOutputPos());
	}


	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	//	LiveWindow.run();
	}

} 