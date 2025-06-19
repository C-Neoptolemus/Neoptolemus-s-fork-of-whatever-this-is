package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="basics", group="Linear OpMode")
public class basics extends LinearOpMode {
private DcMotor fl = null;
private DcMotor bl = null;
private DcMotor fr = null;
private DcMotor br = null;
private double ly;
    private double rx;
    private double lx;
    double powerFL;
    double powerFR;
    double powerBR;
    double powerBL;
    @Override
    public void runOpMode() {
        fl = hardwareMap.get(DcMotor.class, "fl");
        bl = hardwareMap.get(DcMotor.class, "bl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        br = hardwareMap.get(DcMotor.class, "br");
        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        br.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        while(opModeIsActive()){
            ly = gamepad1.left_stick_y;
            rx = gamepad1.right_stick_x;
            lx = gamepad1.left_stick_x;
            powerFL=ly - rx - lx;
            powerFR=ly - rx + lx;
            powerBR=ly + rx - lx;
            powerBL=ly + rx + lx;
            fl.setPower(powerFL);
            bl.setPower(powerBL);
            fr.setPower(powerFR);
            br.setPower(powerBR);

            //br.setPower(gamepad1.right_stick_y);
            telemetry.addData("your code", gamepad1.left_stick_y);
            telemetry.update();
        }
    }
}