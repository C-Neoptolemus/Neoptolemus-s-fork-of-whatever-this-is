package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class LinearSlide {
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private DcMotor linSlide = null;

    public LinearSlide(HardwareMap hardwareMap, Telemetry telemetry){
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        linSlide = hardwareMap.get(DcMotor.class,"linslide");
        SetSlideHeight(0);
        linSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        linSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linSlide.setPower(0);
    }

    public void SetSlideHeight(double inch){
        linSlide.setTargetPosition(InchesToTicks(inch));
    }
    public double GetSlideHeight(){
         return TicksToInches(linSlide.getCurrentPosition());
    }
    public int InchesToTicks(double inches){
        return (int)(inches*(1910.0/37.0));
    }
    public double TicksToInches(double ticks){
        return ticks*(37.0/1910.0);
    }


}
