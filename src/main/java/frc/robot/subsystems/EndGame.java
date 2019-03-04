/*
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;


import frc.robot.RobotMap;
import frc.robot.commands.IntakeManual;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


import edu.wpi.first.wpilibj.DigitalInput;

public class EndGame extends Subsystem {
    
    // Declare Class variables here
	private VictorSPX intakeMotorA;
	private VictorSPX intakeMotorB;
    private DigitalInput beamBreak;
    private static EndGame endGame;
    

    public static EndGame getEndGame() {
    	if (endGame == null) {
    		endGame = new EndGame();
    	}
    	return endGame;
    }
      

    private EndGame(){
    	intakeMotorA = new VictorSPX(RobotMap.INTAKE_MOTOR_A); //Setting whaat motor this is associated with
        intakeMotorB = new VictorSPX(RobotMap.INTAKE_MOTOR_B); //Setting whaat motor this is associated with
        //beamBreak = new DigitalInput(222); //set the port that this is on later
    }
 
	@Override
	protected void initDefaultCommand() {
        //setDefaultCommand(IntakeManual);
    }

    public void setIntakeSpeed(double speedA, double speedB) 
    {
    	
    	intakeMotorA.set(ControlMode.PercentOutput,speedA);
    	intakeMotorB.set(ControlMode.PercentOutput,speedB);
        
    }

}
*/