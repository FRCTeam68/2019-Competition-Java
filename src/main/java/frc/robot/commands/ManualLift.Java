package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;

public class ManualLift extends Command {

    boolean isFinished = false;

    public ManualLift() {
        
		requires(robot.Lift);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
        
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}