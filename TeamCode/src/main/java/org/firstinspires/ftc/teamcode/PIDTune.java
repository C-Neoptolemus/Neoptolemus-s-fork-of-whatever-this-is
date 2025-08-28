package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
@TeleOp
public class PIDTune extends LinearOpMode {
    private DcMotor fl = null;
    //the joystick values representing the movement. ly is fwd and back. rx is turning. lx is strafing
    private double ly;
    private double rx;
    private double lx;

    //this is the the variables that will tell you how much power will go into each motor
    private double powerFL;

    //this is the speed multiplier to slow down to robot for precision
    private double speed;
    LinearSlide linearSlide = null;
    @Override
    public void runOpMode() {
        //giving the variables of the motors control over the actual motors

        fl = hardwareMap.get(DcMotor.class, "fl");

        //the right is reverse but because down is up on the joysticks, we need to make it left instead
        fl.setDirection(DcMotorSimple.Direction.REVERSE);

        //using a brake system where when you aren't applying power to a motor, it will take as much as possible and bring it into the battery (works as a brake as well)
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Claw claw = new Claw(hardwareMap, telemetry);
        linearSlide = new LinearSlide(hardwareMap, telemetry);

        waitForStart();

        while (opModeIsActive()) {

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

            //getting the motors to move
            fl.setPower(powerFL);

            //resetting the speed variable
            speed = 1;

            if (gamepad2.a) {
                claw.Close();
            }else {
                claw.Open();
            }

            telemetry.addData("Height", linearSlide.GetSlideHeight());
            telemetry.update();
            if (gamepad2.y){
                linearSlide.SetSlideHeight(23);
            }
            if (gamepad2.x) {
                linearSlide.SetSlideHeight(0.1);
            }
            if (gamepad2.a){
                linearSlide.TurnMotorOnOrOff();
            }
        }
    }
}
