package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;


import frc.robot.RobotMap;
//import frc.robot.commands.IntakeManual;


//import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


import edu.wpi.first.wpilibj.DigitalInput;

public class Intake extends Subsystem {
    
    // Declare Class variables here
	private WPI_VictorSPX intakeMotor;
    private DigitalInput beamBreak;
    private static Intake intake;
    

    public static Intake getIntake() {
    	if (intake == null) {
    		intake = new Intake();
    	}
    	return intake;
    }
      

    private Intake(){
    	intakeMotor = new WPI_VictorSPX(RobotMap.INTAKE_MOTOR); //Setting whaat motor this is associated with
        beamBreak = new DigitalInput(RobotMap.INTAKE_BEAM_BREAK); //set the port that this is on later
    }
 
	@Override
	protected void initDefaultCommand() {
       // setDefaultCommand(new IntakeManual());
    }

    public void setIntakeSpeed(double speedA) 
    {
    	
    	intakeMotor.set(speedA);
    	
    }
    
    public boolean getBeamBreak(){
        boolean isBeamBreakHit;
        isBeamBreakHit = beamBreak.get();
        return isBeamBreakHit;
    }
    
    public double getIntakeSpeed()
    {
    	return intakeMotor.getMotorOutputPercent();
    }
    
}