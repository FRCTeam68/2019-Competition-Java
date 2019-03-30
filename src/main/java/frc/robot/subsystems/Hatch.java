package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
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
    public DigitalInput hatchLimitSwitch;
    public boolean isHatchIn;
    public boolean reverseHatch;

    public static Hatch getHatch() {
    	if (hatch == null) {
    		hatch = new Hatch();
    	}
    	return hatch;
    }
      

    private Hatch(){
        hatchMotor = new WPI_VictorSPX(RobotMap.HATCH_MOTOR); //Setting whaat motor this is associated with
        hatchLimitSwitch = new DigitalInput(2);
    }
 
	@Override
	protected void initDefaultCommand() {
        setDefaultCommand(new Hatchy());
    }

    public void setHatchSpeed(double speed) 
    {
    	
    	hatchMotor.set(ControlMode.PercentOutput,speed);
    	isHatchIn = hatchLimitSwitch.get();
    }
    
    public double getHatchSpeed()
    {
    	return hatchMotor.getMotorOutputPercent();
    }
    public boolean getLimitSwitch(){
        if(isHatchIn){
            reverseHatch = false;
        } else{
            reverseHatch = true;
        }
        return reverseHatch;
    }
}
