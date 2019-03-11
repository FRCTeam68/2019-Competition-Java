
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;



public class EndGame extends Subsystem {
    
    // Declare Class variables here
	
    private static EndGame endGame;
    

    public static EndGame getEndGame() {
    	if (endGame == null) {
    		endGame = new EndGame();
    	}
    	return endGame;
    }
      

    private EndGame(){


       
    }
 
	@Override
	protected void initDefaultCommand() {
      
    }

    public void setEndGameMotorSpeed(double speedA) 
    {
        
    }

    public void setEndGameMotorPos(double speedA) 
    {
        
    }

    public void getEndGameMotorSpeed(double speedA) 
    {
        
    }

    

}
