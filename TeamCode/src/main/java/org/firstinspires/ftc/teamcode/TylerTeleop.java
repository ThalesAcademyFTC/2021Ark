package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by dcrenshaw on 4/7/19.
 * Clasp is a basic, bare-bones teleop designed to run on top of Anvil.
 */

@TeleOp(name="TylerTeleop", group="Pushbot")
@Disabled
public class TylerTeleop extends OpMode {

    private Anvil robot;
    private F f;

    @Override
    public void init() {
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
        f=new F(hardwareMap, Anvil.Drivetrain.UNNAMED, telemetry);
    }

    @Override
    public void loop() {
        if (gamepad1.atRest())robot.rest();
        else if (gamepad1.right_stick_x > 0.5){
            f.mr(1);
        }
        else if (gamepad1.right_stick_x > -0.5){
            f.ml(1);
        }
        else if (gamepad1.left_stick_y > -0.5){
            f.mf(1);
        }
        else if (gamepad1.left_stick_y > 0.5){
            f.mb(1);
        }
    }
}
