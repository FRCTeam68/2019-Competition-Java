
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;


import frc.robot.RobotMap;
import frc.robot.commands.IntakeManual;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;

public class EndGame extends Subsystem {
    
    // Declare Class variables here
	private WPI_TalonSRX frontLeftMotor;
    private WPI_TalonSRX frontRightMotor;
    private WPI_TalonSRX backRightMotor;
    private WPI_TalonSRX backLeftMotor;
    private DigitalInput beamBreak;
    private static EndGame endGame;
    

    public static EndGame getEndGame() {
    	if (endGame == null) {
    		endGame = new EndGame();
    	}
    	return endGame;
    }
      

    private EndGame(){


        //beamBreak = new DigitalInput(222); //set the port that this is on later
    }
 
	@Override
	protected void initDefaultCommand() {
        //setDefaultCommand(IntakeManual);
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
