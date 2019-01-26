package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.VictorSP;

//import frc.robot.Robot;
import frc.robot.RobotMap;
//import frc.robot.commands.DriveWithXboxJoysticks;
//import frc.robot.commands.IntakeManualIn;
//import frc.robot.commands.IntakeManualXboxJoysticks;

//import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class Intake extends Subsystem {
    
    // Declare Class variables her
    private static Intake intake;
    private DoubleSolenoid intakeClamper;
	private DoubleSolenoid intakeOrientation;
	private VictorSP intakeMotorA;
	private VictorSP intakeMotorB;
	private Value orientationStatus;
    private DigitalInput limitSwitch;
    
    public static Intake getIntake() {
    	if (intake == null) {
    		intake = new Intake();
    	}
    	return intake;
    }
    
    // Constructor
    private Intake()
    {
    	intakeOrientation = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.INTAKE_UP, RobotMap.INTAKE_DOWN);
    	orientationStatus = Value.kForward;
    	intakeClamper = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.INTAKE_CLAMP, RobotMap.INTAKE_NORMAL);
    	intakeMotorA = new VictorSP(RobotMap.INTAKE_MOTOR_A);
    	intakeMotorB = new VictorSP(RobotMap.INTAKE_MOTOR_B);
		limitSwitch = new DigitalInput(RobotMap.INTAKE_LIMIT_SWITCH);
    }
    
    public boolean getSwitch() {
        return limitSwitch.get();
    }

    public void initDefaultCommand() 
    {
    }
    
    public void intakeUpPosition() 
    {
    	intakeOrientation.set(Value.kForward);
    }
    
    public void intakeDownPosition() 
    {
    	intakeOrientation.set(Value.kReverse);
    }
        
    public void setIntakeSpeed(double speedA, double speedB) 
    {
    	
    	/*if(this.getSwitch()) {
    		speedA = 0;
    		speedB = 0;
    	}*/
    	intakeMotorA.set(speedA);
    	intakeMotorB.set(speedB);
    	
    }
    
    public void setIntakeSpeedLeft(double speedA)
    {
    	intakeMotorA.set(speedA);	
    }
    
    public void setIntakeSpeedRight(double speedB)
    {
    	intakeMotorB.set(speedB);
    }
    
    
    public double getIntakeASpeed()
    {
    	return intakeMotorA.get();
    }
    
    public double getIntakeBSpeed()
    {
    	return intakeMotorB.get();
    }
    
    public void intakeClamp() {
    	intakeClamper.set(Value.kForward);
    }
    
    public void intakeNormal() {
    	intakeClamper.set(Value.kReverse);
    }
    
    
    public Value getIntakeStatus() {
    	return orientationStatus;
    }
    
    public void toggleIntake() {
    	if(this.getOrientation() == Value.kForward){
    	  	this.intakeDownPosition();
    	}
    	
    	else {
    		this.intakeUpPosition();
    	}
    }
    
    public DoubleSolenoid.Value getOrientation() {
    	return intakeOrientation.get();
    }
    
    //Clamp Toggle
    
    public DoubleSolenoid.Value getClampStatus() {
    	return intakeClamper.get();
    }
    
    public void toggleClamp() {
    	if(this.getClampStatus() == Value.kForward){
    	  	this.intakeNormal();
    	}
    	
    	else {
    		this.intakeClamp();
    	}
    }
    
    public boolean isClamped() {
    	return (intakeClamper.get() == Value.kForward);
    }
    
}
   