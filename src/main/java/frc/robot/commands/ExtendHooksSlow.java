package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;
import frc.robot.RobotMap;



public class ExtendHooksSlow extends Command 
{
	boolean isFinished = false;
	double speedA = RobotMap.HOOK_MOTOR_1_BACKWARDS/2;
	double speedB = RobotMap.HOOK_MOTOR_2_BACKWARDS/2;
	
    public ExtendHooksSlow() 
   {
    	requires(Robot.endGame);
    }

    
    protected void initialize() 
    {

    }

    
    protected void execute()
   {
    	SmartDashboard.putNumber("speedA Retract", speedA);
    	SmartDashboard.putNumber("speedB Retract", speedB);
    	Robot.endGame.setHookSpeed(speedA, speedB);
    	
    	

    	//isFinished = true;
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
