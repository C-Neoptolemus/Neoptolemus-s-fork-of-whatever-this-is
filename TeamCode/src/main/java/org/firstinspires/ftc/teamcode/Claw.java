package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private Servo right = null;
    private Servo left = null;
    private double openDifference;
    private HardwareMap hardwareMap;
    private double rightClosedServoPos;
    private double leftClosedServoPos;
    public Claw(HardwareMap hardwareMap, double difference){
    openDifference = difference;
    this.hardwareMap = hardwareMap;
    right = hardwareMap.get(Servo.class, "right");
    left = hardwareMap.get(Servo.class,"left");
    left.setPosition(0);
    }
    public void Open(){
        left.setPosition(0);
        right.setPosition(0);
    }
    public void Close(){
        left.setPosition(leftClosedServoPos);
        right.setPosition(rightClosedServoPos);
    }
}
