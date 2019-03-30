package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class EndGameWheelsMove extends Command{

  boolean isFinished = false;
  double triggerValue;
  double speedSpeed;
    public EndGameWheelsMove(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.endGame);
        speedSpeed = speed;
      }
    
      // Called just before this Command runs the first time
      @Override
      protected void initialize() {
    
      }
    
      // Called repeatedly when this Command is scheduled to run
      @Override
      protected void execute() {
        
        Robot.endGame.setEndGameWheelSpeeds(speedSpeed);
       
        isFinished = true;
      
      }
    
      // Make this return true when this Command no longer needs to run execute()
      @Override
      protected boolean isFinished() {
        return isFinished;
      }
    
      // Called once after isFinished returns true
      @Override
      protected void end() {
      }
    
      // Called when another command which requires one or more of the same
      // subsystems is scheduled to run
      @Override
      protected void interrupted() {
      }
    
}