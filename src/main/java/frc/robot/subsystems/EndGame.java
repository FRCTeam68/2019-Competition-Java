package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
import frc.robot.commands.EndGameWheelsMove;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class EndGame extends Subsystem {
    
    // Declare Class variables here
	private WPI_TalonSRX frontLeftMotor;
    private WPI_TalonSRX frontRightMotor;
    private WPI_TalonSRX backRightMotor;
    private WPI_TalonSRX backLeftMotor;
    private WPI_VictorSPX backMotorWheelMotor;
    private static EndGame endGame;
    private double lastFrontSetPoint = 0;
    private double lastBackSetPoint = 0;
    

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
        frontRightMotor.setSensorPhase(true);
        frontRightMotor.configPeakOutputForward(0.75);
        frontRightMotor.configPeakOutputReverse(-0.4);
        frontRightMotor.selectProfileSlot(RobotMap.ENDGAME_PID_SLOT, 0);
		frontRightMotor.config_kF(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_F, 0);
		frontRightMotor.config_kP(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_P, 0);
		frontRightMotor.config_kI(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_I, 0);
        frontRightMotor.config_kD(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_D, 0);

        frontLeftMotor = new WPI_TalonSRX(RobotMap.ENDGAME_FRONT_LEFT);
        frontLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,0);
        frontLeftMotor.setSensorPhase(false);
        frontLeftMotor.configPeakOutputForward(0.75);
        frontLeftMotor.configPeakOutputReverse(-0.4);
        frontLeftMotor.selectProfileSlot(RobotMap.ENDGAME_PID_SLOT, 0);
		frontLeftMotor.config_kF(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_F, 0);
		frontLeftMotor.config_kP(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_P, 0);
		frontLeftMotor.config_kI(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_I, 0);
        frontLeftMotor.config_kD(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_D, 0);

        backLeftMotor = new WPI_TalonSRX(RobotMap.ENDGAME_BACK_LEFT);
        backLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,0);
        backLeftMotor.setSensorPhase(false);
        backLeftMotor.configPeakOutputForward(0.75);
        backLeftMotor.configPeakOutputReverse(-0.5);
        backLeftMotor.selectProfileSlot(RobotMap.ENDGAME_PID_SLOT, 0);
		backLeftMotor.config_kF(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_F, 0);
		backLeftMotor.config_kP(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_P, 0);
		backLeftMotor.config_kI(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_I, 0);
        backLeftMotor.config_kD(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_D, 0);
      
        backRightMotor = new WPI_TalonSRX(RobotMap.ENDGAME_BACK_RIGHT);
        backRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,0);
        backRightMotor.setSensorPhase(true);
        backRightMotor.configPeakOutputForward(0.75);
        backRightMotor.configPeakOutputReverse(-0.5);
        backRightMotor.selectProfileSlot(RobotMap.ENDGAME_PID_SLOT, 0);
		backRightMotor.config_kF(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_F, 0);
		backRightMotor.config_kP(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_P, 0);
		backRightMotor.config_kI(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_I, 0);
        backRightMotor.config_kD(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_D, 0);

        backMotorWheelMotor = new WPI_VictorSPX(RobotMap.ENDGAME_WHEELS);

        frontLeftMotor.setNeutralMode(NeutralMode.Brake);
        backLeftMotor.setNeutralMode(NeutralMode.Brake);
        frontRightMotor.setNeutralMode(NeutralMode.Brake);
        backRightMotor.setNeutralMode(NeutralMode.Brake);
        backMotorWheelMotor.setNeutralMode(NeutralMode.Brake);


    }
 
	@Override
	protected void initDefaultCommand() {
        
    }

    public void setEndGameMotorsSpeed(double speedA,double speedB) 
    {
     frontRightMotor.set(speedA);
     backLeftMotor.set(speedB);
    }

	public void zeroEncoder() {
        frontRightMotor.setSelectedSensorPosition(0, 0, 10);
        backLeftMotor.setSelectedSensorPosition(0, 0, 10);
        frontLeftMotor.setSelectedSensorPosition(0, 0, 10);
        backRightMotor.setSelectedSensorPosition(0, 0, 10);
	}

    public void setEndGameWheelSpeeds(double speedA) 
    {
        System.out.print("Endgame Wheel Speed = "+speedA);
        backMotorWheelMotor.set(speedA);
    }

    public void setMotorPos(double positionFront, double positionBack) 
    {
        frontRightMotor.set(ControlMode.Position, positionFront);
        backLeftMotor.set(ControlMode.Position, positionBack);
        frontLeftMotor.set(ControlMode.Position, positionFront);
        backRightMotor.set(ControlMode.Position, positionBack);
        lastFrontSetPoint = positionFront;
        lastBackSetPoint = positionBack;

    }

    public double getFrontLeftMotorPos() 
    {
        double positionFrontLeft = 0;
		positionFrontLeft = frontLeftMotor.getSelectedSensorPosition(0);
		return positionFrontLeft;
    }

    public double getFrontRightMotorPos() 
    {
        double positionFrontRight = 0;
		positionFrontRight = frontRightMotor.getSelectedSensorPosition(0);
		return positionFrontRight;
    }

    public double getBackRightMotorPos()
    {
        double positionBackRight = 0;
		positionBackRight = backRightMotor.getSelectedSensorPosition(0);
        return positionBackRight;
    }

    public double getBackLeftMotorPos()
    {
        double positionBackLeft = 0;
		positionBackLeft = backLeftMotor.getSelectedSensorPosition(0);
        return positionBackLeft;
    }

    public double getLastFrontSetPoint() {
		return lastFrontSetPoint;
	}

    public double getLastBackSetPoint() {
		return lastBackSetPoint;
	}


}