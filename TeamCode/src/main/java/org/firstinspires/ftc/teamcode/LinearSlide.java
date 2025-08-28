package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class LinearSlide {
   //allows LinearSlide to use hardware and telemetry
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    //creates the linear slide motor
    private DcMotor linSlide = null;
    //turns the power on
    private boolean power = true;

    public LinearSlide(HardwareMap hardwareMap, Telemetry telemetry){
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        linSlide = hardwareMap.get(DcMotor.class,"linslide");
        SetSlideHeight(0);
        linSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        linSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linSlide.setPower(1);
    }
//sets the slide height to an inch ammount
    public void SetSlideHeight(double inch){
        linSlide.setTargetPosition(InchesToTicks(inch));
    }
    public void TurnMotorOnOrOff(){
        if (power){
            linSlide.setPower(0);
            power = false;
        }else{
            linSlide.setPower(1);
            power = true;
        }
    }
    //gets the current slide height
    public double GetSlideHeight(){
         return TicksToInches(linSlide.getCurrentPosition());
    }
    //converts inches to ticks
    public int InchesToTicks(double inches){
        return (int)(inches*(1910.0/37.0));
    }
    //converts ticks to inches
    public double TicksToInches(double ticks){
        return ticks*(37.0/1910.0);
    }


}
