package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;


import frc.robot.RobotMap;
import frc.robot.commands.IntakeManual;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


import edu.wpi.first.wpilibj.DigitalInput;

public class Intake extends Subsystem {
    
    // Declare Class variables here
	private VictorSPX intakeMotorA;
	private VictorSPX intakeMotorB;
    private DigitalInput beamBreak;
    private static Intake intake;
    

    public static Intake getIntake() {
    	if (intake == null) {
    		intake = new Intake();
    	}
    	return intake;
    }
      

    private Intake(){
    	intakeMotorA = new VictorSPX(RobotMap.INTAKE_MOTOR_A); //Setting whaat motor this is associated with
        //beamBreak = new DigitalInput(222); //set the port that this is on later
    }
 
	@Override
	protected void initDefaultCommand() {
        setDefaultCommand(new IntakeManual());
    }

    public void setIntakeSpeed(double speedA, double speedB) 
    {
    	
    	intakeMotorA.set(ControlMode.PercentOutput,speedA);
    	
    }
    public void setIntakeSpeedLeft(double speedA)
    {
    	intakeMotorA.set(ControlMode.Current,speedA);	
    }
    
    public boolean findCurrentStateOfBeamBreak(){
        boolean isBeamBreakHit;
        isBeamBreakHit = beamBreak.get();
        return isBeamBreakHit;
    }
    
    public double getIntakeASpeed()
    {
    	return intakeMotorA.getMotorOutputPercent();
    }
}
