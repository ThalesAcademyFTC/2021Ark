package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TylerTeleop", group="Pushbot")
//@Disabled
public class TylerTeleop extends OpMode {

    private Anvil robot;
    private F f;

    @Override
    public void init(){
        f = new F(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
    }

    @Override
    public void loop() {
        double speed = 1;

        if (gamepad1.atRest())robot.rest();
        else if (gamepad1.right_stick_x > 0.5) {
            f.mr(speed);
        } else if (gamepad1.right_stick_x > -0.5) {
            f.ml(speed);
        } else if (gamepad1.left_stick_y > -0.5) {
            f.mf(speed);
        } else if (gamepad1.left_stick_y > 0.5) {
            f.mb(speed);
        } else if (gamepad1.left_bumper) {
            f.tl(speed);
        } else if(gamepad1.right_bumper) {
            f.tr(speed);
        } else if(gamepad1.dpad_up) {
            f.dtr(speed);
        } else if(gamepad1.dpad_down) {
            f.dbl(speed);
        } else if(gamepad1.dpad_right) {
            f.dbr(speed);
        } else if(gamepad1.dpad_left) {
            f.dtl(speed);
        }
        if(gamepad1.a) {
            speed = 1;
        } else if(gamepad1.b) {
            speed = 0.75;
        } else if(gamepad1.x) {
            speed = 0.5;
        }
        else if(gamepad1.y) {
            speed = 0.25;
        }
    }
}
