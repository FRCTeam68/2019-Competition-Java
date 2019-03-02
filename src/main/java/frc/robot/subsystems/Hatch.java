package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;


import frc.robot.RobotMap;
//import frc.robot.commands.IntakeManual;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


import edu.wpi.first.wpilibj.DigitalInput;

public class Hatch extends Subsystem {
    
    // Declare Class variables here
	private WPI_VictorSPX hatchMotorB;
    private static Hatch hatch;
    

    public static Hatch getHatch() {
    	if (hatch == null) {
    		hatch = new Hatch();
    	}
    	return hatch;
    }
      

    private Hatch(){
    	hatchMotorB = new WPI_VictorSPX(RobotMap.HATCH_MOTOR); //Setting whaat motor this is associated with
    }
 
	@Override
	protected void initDefaultCommand() {
        //setDefaultCommand(new IntakeManual());
    }

    public void setHatchSpeed(double speedA, double speedB) 
    {
    	
    	hatchMotorB.set(ControlMode.PercentOutput,speedA);
    	
    }
    public void setHatchSpeedLeft(double speedA)
    {
    	hatchMotorB.set(ControlMode.Current,speedA);
    }
    
    public double getHatchBSpeed()
    {
    	return hatchMotorB.getMotorOutputPercent();
    }
}
