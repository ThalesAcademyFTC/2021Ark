package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by dcrenshaw on 4/7/19.
 * Clasp is a basic, bare-bones teleop designed to run on top of Anvil.
 */

@TeleOp(name="TrainingTeleop", group="Pushbot")
//@Disabled
public class TrainingTeleop extends OpMode {

    private Anvil robot;

    @Override
    public void init() {
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.UNNAMED, telemetry);
    }
    @Override

    public void loop() {
        telemetry.addData("armMotor1", robot.armMotor.getCurrentPosition());
        telemetry.update();
        if (gamepad1.atRest() && gamepad2.atRest()) robot.rest();
        else if (gamepad1.x){
            robot.armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        } else if (gamepad1.b){
            robot.armMotor.setPower(1);
        } else if (gamepad1.a){
            robot.armMotor.setPower(-1);
        }
        else {
            if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                robot.turnRight(gamepad1.left_stick_x);
            } else robot.moveBackward(gamepad1.left_stick_y);
        }

    }
}