package frc.robot.subsystems;

//import frc.robot.Robot;
import frc.robot.RobotMap;
//import frc.robot.commands.DriveWithXboxJoysticks;
//import frc.robot.commands.LiftManual;
//import frc.robot.commands.LiftManual;
import frc.robot.commands.LiftZeroEncoder;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

//import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Lift extends Subsystem {
	
	private WPI_TalonSRX liftMotor;
    private DigitalInput limitSwitch;
	private Boolean manualBool;
	private double lastSetPoint = 0;
	
	private static Lift lift;
	
	public static Lift getLift() {
		if (lift == null) {
			lift = new Lift();
	}
	return lift;
}
	
	private Lift()
	{
		liftMotor = new WPI_TalonSRX(RobotMap.LIFT_MOTORS);
		liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,0);
		liftMotor.setSensorPhase(false); 
		liftMotor.configNominalOutputForward(0, 0);
		liftMotor.configNominalOutputReverse(0, 0);
		liftMotor.configPeakOutputForward(.3,0); 
		liftMotor.configPeakOutputReverse(-1.0,0); 

		//		liftMotor.configNeutralDeadband(0.001, 0);
		liftMotor.selectProfileSlot(RobotMap.LIFT_PID_SLOT, 0);
		liftMotor.config_kF(RobotMap.LIFT_PID_SLOT, RobotMap.LIFT_PID_F, 0);
		liftMotor.config_kP(RobotMap.LIFT_PID_SLOT, RobotMap.LIFT_PID_P, 0);
		liftMotor.config_kI(RobotMap.LIFT_PID_SLOT, RobotMap.LIFT_PID_I, 0);
		liftMotor.config_kD(RobotMap.LIFT_PID_SLOT, RobotMap.LIFT_PID_D, 0);
		liftMotor.setNeutralMode(NeutralMode.Brake);
		manualBool = false;
		limitSwitch = new DigitalInput(RobotMap.LIFT_LIMIT_SWITCH);

	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new LiftZeroEncoder());
	}
	public void setLiftSpeed(double speed) {
		liftMotor.set(speed);
	}
	public void setControlModePercentOutput(double speed) {
		liftMotor.set(ControlMode.PercentOutput, speed);
	}
	
	public void setPosition(double position) {
		liftMotor.set(ControlMode.Position, position);
		lastSetPoint = position;
	}

	public double getLastSetPoint() {
		return lastSetPoint;
	}
	
/*	public void setMotionMagicPosition(double position) {
		liftMotor.set(ControlMode.MotionMagic, position);
	}
*/	
	public double getPosition() {
		double position = 0;
		position = liftMotor.getSelectedSensorPosition(0);
		return position;
	}
	
	public void zeroEncoder() {
		liftMotor.setSelectedSensorPosition(0, 0, 10);
	}
	
	public boolean getLimitSwitch(){
		return limitSwitch.get();
	}
    

    public void swapManual() {
    	manualBool = !manualBool;
    }
    
    public boolean getManualStatus() {
    	return manualBool;
    }
}