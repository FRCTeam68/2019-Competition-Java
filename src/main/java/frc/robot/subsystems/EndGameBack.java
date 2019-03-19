package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class EndGameBack extends Subsystem {
    
    // Declare Class variables here
    private WPI_TalonSRX backRightMotor;
    private WPI_TalonSRX backLeftMotor;
    private WPI_VictorSPX backMotorWheelMotor;
    private double lastBackSetPoint;
    private static EndGameBack endGameBack;

    public static EndGameBack getEndGame() {
    	if (endGameBack == null) {
    		endGameBack = new EndGameBack();
    	}
    	return endGameBack;
    }
      

    private EndGameBack(){

        backLeftMotor = new WPI_TalonSRX(RobotMap.ENDGAME_BACK_LEFT);
        backLeftMotor.setSensorPhase(false); 
        backLeftMotor.configNominalOutputForward(0, 0);
		backLeftMotor.configNominalOutputReverse(0, 0);
		backLeftMotor.configPeakOutputForward(.3,0); 
		backLeftMotor.configPeakOutputReverse(-.7,0);
        backLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,0);
        backLeftMotor.selectProfileSlot(RobotMap.ENDGAME_BACK_PID_SLOT, 0);
		backLeftMotor.config_kF(RobotMap.ENDGAME_BACK_PID_SLOT, RobotMap.ENDGAME_BACK_PID_F, 0);
		backLeftMotor.config_kP(RobotMap.ENDGAME_BACK_PID_SLOT, RobotMap.ENDGAME_BACK_PID_P, 0);
		backLeftMotor.config_kI(RobotMap.ENDGAME_BACK_PID_SLOT, RobotMap.ENDGAME_BACK_PID_I, 0);
        backLeftMotor.config_kD(RobotMap.ENDGAME_BACK_PID_SLOT, RobotMap.ENDGAME_BACK_PID_D, 0);
      
        backRightMotor = new WPI_TalonSRX(RobotMap.ENDGAME_BACK_RIGHT);
        backRightMotor.set(ControlMode.Follower, backLeftMotor.getDeviceID());

        backMotorWheelMotor = new WPI_VictorSPX(RobotMap.ENDGAME_BACK_MOTOR_WHEEL);

        backLeftMotor.setNeutralMode(NeutralMode.Brake);
        backMotorWheelMotor.setNeutralMode(NeutralMode.Brake);
        backRightMotor.setNeutralMode(NeutralMode.Brake);


    }
 
	@Override
	protected void initDefaultCommand() {
        //setDefaultCommand(IntakeManual);.0
    }

    public void setEndGameMotorsSpeed(double speedB) 
    {

     backLeftMotor.set(speedB);
    }

	public void zeroEncoder() {
        backLeftMotor.setSelectedSensorPosition(0, 0, 10);
	}

    public void setEndGameWheelSpeeds(double speedA) 
    {
        backMotorWheelMotor.set(speedA);
    }

    public void setMotorPos(double positionBack) 
    {
        backLeftMotor.set(ControlMode.Position, positionBack);
        lastBackSetPoint = positionBack;

    }

    public double getBackMotorPos()
    {
        double positionBack = 0;
		positionBack = backRightMotor.getSelectedSensorPosition(0);
        return positionBack;
    }

    public double getLastBackSetPoint() {
		return lastBackSetPoint;
	}
}