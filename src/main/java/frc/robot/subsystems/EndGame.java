/*
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;

public class EndGame extends Subsystem {
    
    // Declare Class variables here
	private WPI_TalonSRX frontLeftMotor;
    private WPI_TalonSRX frontRightMotor;
    private WPI_TalonSRX backRightMotor;
    private WPI_TalonSRX backLeftMotor;
    private WPI_VictorSPX frontRightMotorWheelMotor;
    private static EndGame endGame;
    

    public static EndGame getEndGame() {
    	if (endGame == null) {
    		endGame = new EndGame();
    	}
    	return endGame;
    }
      

    private EndGame(){

        // CREATE PID VALUES FOR ENDGAME
        frontRightMotor = new WPI_TalonSRX(RobotMap.ENDGAME_FRONT_RIGHT); // slave this motor
        frontRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,0);
        frontRightMotor.selectProfileSlot(RobotMap.ENDGAME_PID_SLOT, 0);
		frontRightMotor.config_kF(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_F, 0);
		frontRightMotor.config_kP(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_P, 0);
		frontRightMotor.config_kI(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_I, 0);
        frontRightMotor.config_kD(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_D, 0);

        backLeftMotor = new WPI_TalonSRX(RobotMap.ENDGAME_BACK_LEFT);
        backLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,0);
        backLeftMotor.selectProfileSlot(RobotMap.ENDGAME_PID_SLOT, 0);
		backLeftMotor.config_kF(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_F, 0);
		backLeftMotor.config_kP(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_P, 0);
		backLeftMotor.config_kI(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_I, 0);
        backLeftMotor.config_kD(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_D, 0);
        

        backRightMotor = new WPI_TalonSRX(RobotMap.ENDGAME_BACK_RIGHT); // slave this motor
        backRightMotor.set(ControlMode.Follower, frontLeftMotor.getDeviceID());

        frontLeftMotor = new WPI_TalonSRX(RobotMap.ENDGAME_FRONT_LEFT);
        frontRightMotor.set(ControlMode.Follower, frontLeftMotor.getDeviceID());
    
        //seat motors for driving
       frontRightMotorWheelMotor = new WPI_VictorSPX(RobotMap.ENDGAME_WHEELS);
       frontRightMotorWheelMotor.configNominalOutputForward(0, 0);
		frontRightMotorWheelMotor.configNominalOutputReverse(0, 0);
		frontRightMotorWheelMotor.configPeakOutputForward(1,0); 
       frontRightMotorWheelMotor.configPeakOutputReverse(-1,0); 


    }
 
	@Override
	protected void initDefaultCommand() {
        //setDefaultCommand(IntakeManual);.0
    }
    /*

    public void setEndGameMotorsSpeed(double speedA) 
    {
     backLeftMotor.set(speedA);   
     frontRightMotor.set(speedA);
    }

	public void zeroEncoder() {
        frontLeftMotor.setSelectedSensorPosition(0, 0, 10);
        backLeftMotor.setSelectedSensorPosition(0, 0, 10);
	}

    public void setEndGameWheelSpeeds(double speedA) 
    {
        frontRightMotorWheelMotor.set(speedA);
    }

    public void setBackMotorPos(double positionBack) 
    {
       backLeftMotor.set(ControlMode.Position, positionBack); 
    }

    public void setFrontMotorPos(double positionFront) 
    {
        frontRightMotor.set(ControlMode.Position, positionFront); 
    }

    public double getBackMotorPos() 
    {
        double positionBack = 0;
		positionBack = backLeftMotor.getSelectedSensorPosition(0);
		return positionBack;
    }

    public double getFrontMotorPos() 
    {
        double positionFront = 0;
		positionFront = frontLeftMotor.getSelectedSensorPosition(0);
		return positionFront;
    }

    public double getBackMotorSpeed() 
    {
        return frontLeftMotor.getMotorOutputPercent();
    }
    public double getFrontMotorSpeed() 
    {
        return backLeftMotor.getMotorOutputPercent();
    }

    */

//}