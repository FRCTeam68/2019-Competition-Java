package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class EndGame extends Subsystem {
    
    // Declare Class variables here
	private WPI_TalonSRX frontLeftMotor;
    private WPI_TalonSRX frontRightMotor;
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
        frontRightMotor.setSensorPhase(false); 
        frontRightMotor.configNominalOutputForward(0, 0);
		frontRightMotor.configNominalOutputReverse(0, 0);
		frontRightMotor.configPeakOutputForward(.3,0); 
		frontRightMotor.configPeakOutputReverse(-.7,0); 
        frontRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,0);
        frontRightMotor.selectProfileSlot(RobotMap.ENDGAME_PID_SLOT, 0);
		frontRightMotor.config_kF(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_F, 0);
		frontRightMotor.config_kP(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_P, 0);
		frontRightMotor.config_kI(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_I, 0);
        frontRightMotor.config_kD(RobotMap.ENDGAME_PID_SLOT, RobotMap.ENDGAME_PID_D, 0);

        frontLeftMotor = new WPI_TalonSRX(RobotMap.ENDGAME_FRONT_LEFT);
        frontLeftMotor.set(ControlMode.Follower, frontRightMotor.getDeviceID());


    }
 
	@Override
	protected void initDefaultCommand() {
        //setDefaultCommand(IntakeManual);
    }

    public void setEndGameMotorsSpeed(double speedA,double speedB) 
    {
     frontRightMotor.set(speedA);
    }

	public void zeroEncoder() {
        frontRightMotor.setSelectedSensorPosition(0, 0, 10);
	}

    public void setMotorPos(double positionFront) 
    {
        frontRightMotor.set(ControlMode.Position, positionFront);
    }

    public double getFrontMotorPos() 
    {
        double positionFront = 0;
		positionFront = frontLeftMotor.getSelectedSensorPosition(0);
        return positionFront;
    }

}