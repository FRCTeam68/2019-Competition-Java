package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;


import frc.robot.RobotMap;
//import frc.robot.commands.IntakeManual;
import frc.robot.commands.Hatchy;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class Hatch extends Subsystem {
    
    // Declare Class variables here
	private WPI_VictorSPX hatchMotor;
    private static Hatch hatch;
    

    public static Hatch getHatch() {
    	if (hatch == null) {
    		hatch = new Hatch();
    	}
    	return hatch;
    }
      

    private Hatch(){
    	hatchMotor = new WPI_VictorSPX(RobotMap.HATCH_MOTOR); //Setting whaat motor this is associated with
    }
 
	@Override
	protected void initDefaultCommand() {
        //setDefaultCommand(new Hatchy());
    }

    public void setHatchSpeed(double speed) 
    {
    	
    	hatchMotor.set(ControlMode.PercentOutput,speed);
    	
    }
    
    public double getHatchSpeed()
    {
    	return hatchMotor.getMotorOutputPercent();
    }
}
