package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Sweeper extends Subsystem {
    
    // Declare Class variables here
	private VictorSPX sweeperMotorA;
    
    private WPI_TalonSRX sweeperRotator;

    private static Sweeper sweeper;
    

    public static Sweeper getSweeper() {
    	if (sweeper == null) {
    		sweeper = new Sweeper();
    	}
    	return sweeper;
    }
      

    private Sweeper(){
    	sweeperMotorA = new VictorSPX(RobotMap.INTAKE_MOTOR_A); //Setting whaat motor this is associated with
        
        sweeperRotator = new WPI_TalonSRX(2);
		sweeperRotator.setSensorPhase(true); 
		sweeperRotator.configNominalOutputForward(0, 0);
		sweeperRotator.configNominalOutputReverse(0, 0);
		sweeperRotator.configPeakOutputForward(0.4,0); 
		sweeperRotator.configPeakOutputReverse(0.4,0); 
//		sweeperRotator.configNeutralDeadband(0.001, 0);
		sweeperRotator.selectProfileSlot(RobotMap.LIFT_PID_SLOT, 0);
    }
 
	@Override
	protected void initDefaultCommand() {

    }

    public void setSweeperSpeed(double speedA, double speedB) 
    {
    	
    	sweeperMotorA.set(ControlMode.PercentOutput,speedA);
    	
    	
    }
    public void setSweeperSpeedLeft(double speedA)
    {
    	sweeperMotorA.set(ControlMode.Current,speedA);	
    }
    public void setPosition(double position) {
		sweeperRotator.set(ControlMode.Position, position);
    }
    
    
    public void setControlModePercentOutput(double speed) {
		sweeperRotator.set(ControlMode.PercentOutput, speed);
    }

    public double getSweeperASpeed()
    {
    	return sweeperMotorA.getMotorOutputPercent();
    }
    
    

    public double getPosition() {
		double position = 0;
		position = sweeperRotator.getSelectedSensorPosition(0);
		return position;
	}

}
