package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by dcrenshaw on 4/7/19.
 * Clasp is a basic, bare-bones teleop designed to run on top of Anvil.
 */

@TeleOp(name="JTeleope", group="Pushbot")
public class JTeleop extends OpMode {

    private Anvil robot;


    @Override
    public void init() {
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.UNNAMED, telemetry);
    }

    @Override
    public void loop() {
        //Teleop functions go here

            if (gamepad1.a) {
                robot.liftClaw();
            }
            if (gamepad1.dpad_up) {
                robot.halframp();
            }
            if (gamepad1.dpad_right) {
                robot.highramp();
            }
            if (gamepad1.dpad_left) {
                robot.loadRamp();
            }
            if (gamepad1.left_trigger > 0.5) {
                robot.collectRing();
            } else if (gamepad1.right_trigger > 0.5) {
                robot.fireRing();
            } else {
                robot.cmotor1.setPower(0);
            }
             if (gamepad1.left_bumper) {
                robot.armMotorDown(); }
             else if (gamepad1.right_bumper) {
                robot.armMotorUp(); }

        if (gamepad1.left_bumper){}
        if (gamepad1.dpad_left){}
        if (gamepad1.left_trigger > 0.5){}
        robot.lowerClaw();
        robot.liftClaw();
        robot.loadRamp();
        robot.highramp();
        robot.halframp();
        robot.armMotorDown();
        robot.armMotorUp();

        if (gamepad1.atRest()) robot.rest();
        else {
            if (Math.abs(gamepad1.left_stick_x) + Math.abs(gamepad1.left_stick_y) > 1.3) {
                robot.moveDiagonal(gamepad1.left_stick_x, -gamepad1.left_stick_y, 1);
            } else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                robot.holoMoveLeft(gamepad1.left_stick_x);
            } else if (Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.right_stick_y)) {
                robot.turnRight(gamepad1.right_stick_x);
            } else robot.moveBackward(gamepad1.left_stick_y);
        }
    }
}