package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by dcrenshaw on 4/7/19.
 * Clasp is a basic, bare-bones teleop designed to run on top of Anvil.
 */

@TeleOp(name="AGTeleop", group="Pushbot")
//@Disabled
public class AlexTeleop extends OpMode {

    private Anvil robot;

    @Override
    public void init() {
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.UNNAMED, telemetry);
    }

    @Override
    public void loop() {

//================================================================================================\\
//================================================================================================\\
//================================================================================================\\
        double speed = 1;
        double half = 0.5;
        int none = 0;

//================================================================================================\\

        if (gamepad1.right_stick_x > half) {
            robot.turnRight(speed);
        }
        if (gamepad1.left_stick_y > half) {
            robot.moveBackward(speed);
        }
        if (gamepad1.left_stick_x > half) {
            robot.moveRight(speed);
        }
        if (gamepad1.right_trigger > half) {
            robot.motor1.setPower(-speed);
            robot.motor2.setPower(speed);
            robot.motor3.setPower(-speed);
            robot.motor4.setPower(speed);
        }
        if (gamepad1.right_bumper) {
            robot.motor1.setPower(-speed);
            robot.motor2.setPower(none);
            robot.motor3.setPower(-speed);
            robot.motor4.setPower(none);
        }
        if (gamepad1.left_trigger > half) {
            robot.motor1.setPower(speed);
            robot.motor2.setPower(-speed);
            robot.motor3.setPower(speed);
            robot.motor4.setPower(-speed);
        }
        if (gamepad1.left_bumper) {
            robot.motor1.setPower(none);
            robot.motor2.setPower(-speed);
            robot.motor3.setPower(none);
            robot.motor4.setPower(-speed);
        }
        if (gamepad1.b) {
            speed = 0.5;
        }
        if (gamepad1.a) {
            speed = 1;
        }
//================================================================================================\\
//================================================================================================\\
//================================================================================================\\
        if (gamepad2.right_stick_x > half) {
            robot.turnRight(speed);
        }
        if (gamepad2.left_stick_y > half) {
            robot.moveBackward(speed);
        }
        if (gamepad2.left_stick_x > half) {
            robot.moveRight(speed);
        }
        if (gamepad2.right_trigger > half) {
            robot.motor1.setPower(speed);
            robot.motor2.setPower(-speed);
            robot.motor3.setPower(speed);
            robot.motor4.setPower(-speed);
        }
        if (gamepad2.right_bumper) {
            robot.motor1.setPower(speed);
            robot.motor2.setPower(none);
            robot.motor3.setPower(speed);
            robot.motor4.setPower(none);
        }
        if (gamepad2.left_trigger > half) {
            robot.motor1.setPower(-speed);
            robot.motor2.setPower(speed);
            robot.motor3.setPower(-speed);
            robot.motor4.setPower(speed);
        }
        if (gamepad2.left_bumper) {
            robot.motor1.setPower(none);
            robot.motor2.setPower(speed);
            robot.motor3.setPower(none);
            robot.motor4.setPower(speed);
        }
        if (gamepad2.b) {
            speed = 0.5;
        }
        if (gamepad2.a) {
            speed = 1;
        }
    }
}

