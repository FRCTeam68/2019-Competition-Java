package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;



public class WinchUp extends Command 
{
	boolean isFinished = false;

	
    public WinchUp() 
   {
    	requires(Robot.endGame);
    }

    
    protected void initialize() 
    {
    	Robot.compressor.stop();
    }

    
    protected void execute()
   {
    	Robot.endGame.setWinchSpeed(RobotMap.WINCH_MOTOR_1_FORWARDS, RobotMap.WINCH_MOTOR_2_BACKWARDS);
   
    	//isFinished = true;
   }

   
    protected boolean isFinished() 
   {
        return isFinished;
   }

    
    protected void end() 
   {
    	Robot.endGame.setWinchSpeed(RobotMap.WINCH_MOTOR_STOP, RobotMap.WINCH_MOTOR_STOP);
    	Robot.compressor.start();
    }

    
    protected void interrupted() 
    {

    	Robot.endGame.setWinchSpeed(RobotMap.WINCH_MOTOR_STOP, RobotMap.WINCH_MOTOR_STOP);
    	Robot.compressor.start();
   	
    }
}
