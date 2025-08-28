package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

// This is the class for the claw. It has methods to open and close the claw, as well as manual control for each servo.
public class Claw {
    private Servo right = null;
    private Servo left = null;
    private final double OPEN_DIFFERENCE = 0.0600;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private final double LEFT_CLOSED_SERVO_POS = 0.5578;
    private final double RIGHT_CLOSED_SERVO_POS = 0.3296;
    public Claw(HardwareMap hardwareMap, Telemetry telemetry){
    this.hardwareMap = hardwareMap;
    this.telemetry = telemetry;
    right = hardwareMap.get(Servo.class, "right");
    left = hardwareMap.get(Servo.class,"left");
    Open();
    }
    public void Open(){
        left.setPosition(LEFT_CLOSED_SERVO_POS + OPEN_DIFFERENCE);
        right.setPosition(RIGHT_CLOSED_SERVO_POS - OPEN_DIFFERENCE);
    }
    public void Close(){
        left.setPosition(LEFT_CLOSED_SERVO_POS);
        right.setPosition(RIGHT_CLOSED_SERVO_POS);
    }
    public void RightManual(double position){
        right.setPosition(position);
        telemetry.addData("Right Degrees", position);
    }
    public void LeftManual(double position){
        left.setPosition(position);
        telemetry.addData("Left Degrees", position);
    }
}
