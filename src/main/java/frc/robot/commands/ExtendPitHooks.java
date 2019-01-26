package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;



public class ExtendPitHooks extends Command 
{
	boolean isFinished = false;

	
    public ExtendPitHooks() 
   {
    	requires(Robot.endGame);
    }

    
    protected void initialize() 
    {
    }

    
    protected void execute()
   {
    	Robot.endGame.setHookSpeed(RobotMap.HOOK_MOTOR_1_PITSPEED_FORWARDS, RobotMap.HOOK_MOTOR_1_PITSPEED_FORWARDS);
    	isFinished = true;
   }

   
    protected boolean isFinished() 
   {
        return isFinished;
   }

    
    protected void end() 
   {
     	Robot.endGame.setHookSpeed(RobotMap.HOOK_MOTOR_1_STOP, RobotMap.HOOK_MOTOR_1_STOP);

    }

    
    protected void interrupted() 
    {

     	Robot.endGame.setHookSpeed(RobotMap.HOOK_MOTOR_1_STOP, RobotMap.HOOK_MOTOR_1_STOP);

    }
}
