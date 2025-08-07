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
        linSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        linSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linSlide.setPower(0);
    }

    public void SetSlideHeight(double inch){

    }
    public double GetSlideHeight(){
         return linSlide.getCurrentPosition();
         //1887
    }
    public double InchesToTicks(int inches){
        double circumference = 37.31*3.14;
        double distancePerDegree = circumference/25.4;
        double degreesPerRevO = 1.0/360;
        double RevOPerRevM = 15.1147;
        double RevMPerTick = 28;
        return inches*distancePerDegree*degreesPerRevO*RevOPerRevM*RevMPerTick;
    }
    public double TicksToInches(int ticks){
        double circumference = 37.31*Math.PI;
        double revMPerTick = 1.0/28.0;
        double revOPerRevM = 1.0/15.1147;
        double degreePerRevO = 360;
        double distancePerDegree = circumference/25.4;
        return ticks*revMPerTick*revOPerRevM*degreePerRevO*distancePerDegree;
    }


}
