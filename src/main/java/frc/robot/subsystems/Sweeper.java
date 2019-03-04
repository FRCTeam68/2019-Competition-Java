package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Sweeper extends Subsystem {
    
    // Declare Class variables here
	private WPI_VictorSPX sweeperMotor;
    
    private WPI_TalonSRX sweeperWrist;

    private static Sweeper sweeper;
    

    public static Sweeper getSweeper() {
    	if (sweeper == null) {
    		sweeper = new Sweeper();
    	}
    	return sweeper;
    }
      

    private Sweeper(){

    	sweeperMotor = new WPI_VictorSPX(RobotMap.SWEEPER_MOTOR); //Setting whaat motor this is associated with
        sweeperWrist = new WPI_TalonSRX(RobotMap.SWEEPER_WRIST_MOTOR); 

		/*sweeperRotator.setSensorPhase(true); 
		sweeperRotator.configNominalOutputForward(0, 0);
		sweeperRotator.configNominalOutputReverse(0, 0);
		sweeperRotator.configPeakOutputForward(0.4,0); 
		sweeperRotator.configPeakOutputReverse(0.4,0); 
        //sweeperRotator.configNeutralDeadband(0.001, 0);
        sweeperRotator.selectProfileSlot(RobotMap.LIFT_PID_SLOT, 0);*/

    }
	@Override
	protected void initDefaultCommand() {
        
    }

    public void setSweeperSpeed(double speedA) 
    {
    	sweeperMotor.set(ControlMode.PercentOutput,speedA);
    }

    public void setPosition(double position) {
        sweeperWrist.set(ControlMode.Position, position);
        
    }

    public void zeroEncoder() {
		sweeperWrist.setSelectedSensorPosition(0, 0, 10);
	}

    public double getSensorPos(){

        double position = 0;
		position = sweeperWrist.getSelectedSensorPosition(0);
        return position;
        
    }
    
    public void setControlModePercentOutput(double speed) {
		sweeperWrist.set(ControlMode.PercentOutput, speed);
    }

    public double getSweeperASpeed()
    {
    	return sweeperMotor.getMotorOutputPercent();
    }
    
    

    public double getPosition() {
		double position = 0;
		position = sweeperWrist.getSelectedSensorPosition(0);
		return position;
	}

}