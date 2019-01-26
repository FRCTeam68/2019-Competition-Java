package frc.robot.commands;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LiftCommandGroupAutonCross extends CommandGroup {

    public LiftCommandGroupAutonCross() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new WaitCommand(5));
    	addSequential(new LiftSetPosition(RobotMap.LIFT_HIGH_SCALE));
    	addSequential(new WaitCommand(1.75));
    	addSequential(new IntakeDownPosition());
    	addSequential(new WaitCommand(0.25));
    	addSequential(new IntakeAutoOut());
    	addSequential(new IntakeUpPosition());
    	addSequential(new WaitCommand(0.25));
    	addSequential(new LiftSetPosition(RobotMap.LIFT_GROUND));

    }
}
