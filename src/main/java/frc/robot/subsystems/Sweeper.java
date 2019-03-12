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

		sweeperWrist.setSensorPhase(false); 
		sweeperWrist.configNominalOutputForward(0, 0);
		sweeperWrist.configNominalOutputReverse(0, 0);
		sweeperWrist.configPeakOutputForward(0.75,0); 
		sweeperWrist.configPeakOutputReverse(-0.75,0); 
        //sweeperWrist.configNeutralDeadband(0.001, 0);
        sweeperWrist.selectProfileSlot(RobotMap.SWEEPER_PID_SLOT, 0);
        sweeperWrist.config_kF(RobotMap.SWEEPER_PID_SLOT, RobotMap.SWEEPER_PID_F, 0);
		sweeperWrist.config_kP(RobotMap.SWEEPER_PID_SLOT, RobotMap.SWEEPER_PID_P, 0);
		sweeperWrist.config_kI(RobotMap.SWEEPER_PID_SLOT, RobotMap.SWEEPER_PID_I, 0);
		sweeperWrist.config_kD(RobotMap.SWEEPER_PID_SLOT, RobotMap.SWEEPER_PID_D, 0);

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
    
    public boolean isDeployed(){
        return (sweeperWrist.getSelectedSensorPosition(0)> 1000);
    }

}