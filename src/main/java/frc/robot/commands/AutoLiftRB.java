
package frc.robot.commands;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class AutoLiftRB extends Command {
	
	private boolean isFinished = false;
	private double setPoint = 0;
	private double currentPos = 0;

	public AutoLiftRB() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lift);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		setPoint = Robot.lift.getLastSetPoint();
	//	System.out.println("Initial position LB is " + setPoint);
	}

	// Called repeatedly when this Command is scheduled to run+
	@Override
	protected void execute() {
	//	System.out.println("Holding Left Button");
		if(Robot.oi.getXboxManipulateRB() || Robot.oi.getXboxManipulateRTButton()) {
			if(Robot.oi.getXboxManipulateCircle()){
				Scheduler.getInstance().add(new AutoWrist(RobotMap.INTAKE_WRIST_CARGO_OUTPUT));
				setPoint = RobotMap.LIFT_ROCKET_HATCH_MID;
			}
			else if(Robot.oi.getXboxManipulateX() ){
				Scheduler.getInstance().add(new AutoWrist(RobotMap.INTAKE_WRIST_CARGO_OUTPUT));
				setPoint = RobotMap.LIFT_ROCKET_CARGO_LOW;
				
	//			System.out.println("And A or B was pressed");
			} else if (Robot.oi.getXboxManipulateSquare()) {
	//			System.out.println("And X was pressed");
				Scheduler.getInstance().add(new AutoWrist(RobotMap.INTAKE_WRIST_CARGO_OUTPUT));
				setPoint = RobotMap.LIFT_ROCKET_CARGO_MID;
				
			} else if (Robot.oi.getXboxManipulateTriangle()) {
	//			System.out.println("And Y was pressed");
				Scheduler.getInstance().add(new AutoWrist(RobotMap.INTAKE_WRIST_CARGO_OUTPUT));
				setPoint = RobotMap.LIFT_ROCKET_CARGO_HIGH;
				
			}
		}
	//	System.out.println("Setting setPoint to LB " + setPoint);
		Robot.lift.setPosition(setPoint);
		currentPos = Robot.lift.getPosition();
		if ( currentPos == setPoint ) {
			isFinished = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		System.out.println("LB WhileHeld Ended " + setPoint);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}