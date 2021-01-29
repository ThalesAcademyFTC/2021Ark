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
        telemetry.addData("armMotor", robot.armMotor.getCurrentPosition());
        telemetry.update();
        if (gamepad1.atRest() && gamepad2.atRest()) robot.rest();
        else if (gamepad1.x) robot.loadRamp();
        else if(gamepad1.y) robot.halframp();
        else if (gamepad1.b) robot.highramp();
        else {
            if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                robot.turnRight(gamepad1.left_stick_x);
            } else robot.moveBackward(gamepad1.left_stick_y);
        }

        if (gamepad1.dpad_up){
            robot.armServo.setPosition(0);
        }
        else if (gamepad1.dpad_down){
            robot.armServo.setPosition(1);
        }
        else if (gamepad1.dpad_right){
            robot.armServo.setPosition(0.25);
        } else if (gamepad1.dpad_left){
            robot.armServo.setPosition(0.75);
        }

        if (gamepad1.right_bumper){
            robot.armMotorUp();
        } else if (gamepad1.left_bumper){
            robot.armMotor.setPower(-1);
        } else {
            robot.armMotor.setPower(0);
        }
    }
}