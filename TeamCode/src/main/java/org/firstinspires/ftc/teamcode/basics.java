package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
/*
This is the op mode I made so that I can take advantage of the robot oriented drive. I also made it a slow mo button.
 */
@TeleOp(name="basics", group="Linear OpMode")
public class basics extends LinearOpMode {
    //initializing all of the motors

    //creating all four motor base objects. fl = front left, br = back left ect...
    private DcMotor fl = null;
    private DcMotor bl = null;
    private DcMotor fr = null;
    private DcMotor br = null;

    //the joystick values representing the movement. ly is fwd and back. rx is turning. lx is strafing
    private double ly;
    private double rx;
    private double lx;

    //this is the the variables that will tell you how much power will go into each motor
    private double powerFL;
    private double powerFR;
    private double powerBR;
    private double powerBL;

    //this is the speed multiplier to slow down to robot for precision
    private double speed;

    @Override
    public void runOpMode() {
        //giving the variables of the motors control over the actual motors
        fl = hardwareMap.get(DcMotor.class, "fl");
        bl = hardwareMap.get(DcMotor.class, "bl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        br = hardwareMap.get(DcMotor.class, "br");

        //the right is reverse but because down is up on the joysticks, we need to make it left instead
        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);

        //useing a brake system where when you aren't applying power to a motor, it will take as much as possible and bring it into the battery (works as a brake as well)
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Claw claw = new Claw(hardwareMap, 0);

        waitForStart();

        while(opModeIsActive()){

            //slow modes
            if (gamepad1.right_trigger > 0.4){
                speed = 0.5;
            }else if (gamepad1.right_bumper) {
                speed = 0.75;
            }

            //getting the joystick variables be the actual joystick value
            ly = -gamepad1.left_stick_y;
            rx = gamepad1.right_stick_x;
            lx = gamepad1.left_stick_x;

            //the formula to getting the motors to move correctly
            powerFL=(ly + rx + lx)*speed;
            powerFR=(ly - rx - lx)*speed;
            powerBR=(ly - rx + lx)*speed;
            powerBL=(ly + rx - lx)*speed;

            //getting the motors to move
            fl.setPower(powerFL);
            bl.setPower(powerBL);
            fr.setPower(powerFR);
            br.setPower(powerBR);

            //resetting the speed variable
            speed = 1;

        }
    }
}