package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="basics", group="Linear OpMode")
public class basics extends LinearOpMode {
private DcMotor fl = null;
private DcMotor bl = null;
private DcMotor fr = null;
private DcMotor br = null;
private double leftJoyStickY;
    private double rightJoyStickY;
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
            fl.setPower(gamepad1.left_stick_y);
            bl.setPower(gamepad1.left_stick_y);
            fr.setPower(gamepad1.right_stick_y);
            br.setPower(gamepad1.right_stick_y);
            telemetry.addData("your code", gamepad1.left_stick_y);
            telemetry.update();
        }
    }
}
