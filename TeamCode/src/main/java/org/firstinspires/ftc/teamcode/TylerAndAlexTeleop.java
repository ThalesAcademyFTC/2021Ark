package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by dcrenshaw on 4/7/19.
 * Clasp is a basic, bare-bones teleop designed to run on top of Anvil.
 */

@TeleOp(name="TylerAndAlexTeleop", group="Pushbot")
//@Disabled
public class TylerAndAlexTeleop extends OpMode {

    private Anvil robot;

    @Override
    public void init() {
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
    }

    @Override
    public void loop() {

//====================================Movement====================================================\\

        robot.moveForward(gamepad1.left_stick_y);
        robot.moveLeft(gamepad1.right_stick_x);

//====================================Turning=====================================================\\

        robot.turnLeft(gamepad1.left_trigger);
        robot.turnRight(gamepad1.right_trigger);

//================================Diagonal Movement===============================================\\
        if (gamepad1.atRest() && gamepad2.atRest()) robot.rest();
        else if (gamepad1.dpad_up) {
            robot.motor1.setPower(1);
            robot.motor2.setPower(0);
            robot.motor3.setPower(0);
            robot.motor4.setPower(1);
        } else if (gamepad1.dpad_down) {
            robot.motor1.setPower(-1);
            robot.motor2.setPower(0);
            robot.motor3.setPower(0);
            robot.motor4.setPower(-1);
        } else if (gamepad1.dpad_right) {
            robot.motor1.setPower(0);
            robot.motor2.setPower(1);
            robot.motor3.setPower(1);
            robot.motor4.setPower(0);
        } else if (gamepad1.dpad_left) {
            robot.motor1.setPower(0);
            robot.motor2.setPower(-1);
            robot.motor3.setPower(-1);
            robot.motor4.setPower(0);
        } else if (gamepad1.a) {
            //move backwards
            robot.motor1.setPower(-1);
            robot.motor2.setPower(-1);
            robot.motor3.setPower(-1);
            robot.motor4.setPower(-1);
        } else if (gamepad1.y) {
            //move forward
            robot.motor1.setPower(1);
            robot.motor2.setPower(1);
            robot.motor3.setPower(1);
            robot.motor4.setPower(1);
        } else if (gamepad1.x) {
            //move left
            robot.motor1.setPower(1);
            robot.motor2.setPower(-1);
            robot.motor3.setPower(-1);
            robot.motor4.setPower(1);
        } else if (gamepad1.b) {
            //move right
            robot.motor1.setPower(-1);
            robot.motor2.setPower(1);
            robot.motor3.setPower(1);
            robot.motor4.setPower(-1);
        } else if (gamepad1.left_bumper) {
            //turn left
            robot.motor1.setPower(-1);
            robot.motor2.setPower(1);
            robot.motor3.setPower(-1);
            robot.motor4.setPower(1);
        } else if (gamepad1.right_bumper) {
            //turn right
            robot.motor1.setPower(1);
            robot.motor2.setPower(-1);
            robot.motor3.setPower(1);
            robot.motor4.setPower(-1);
        }

        //impotant comment========================================================================//
        //impotant comment========================================================================//
        //impotant comment========================================================================//
        //impotant comment========================================================================//
//====================================Movement====================================================\\

        robot.moveBackward(gamepad2.left_stick_y);
        robot.moveRight(gamepad2.right_stick_x);

//====================================Turning=====================================================\\

        robot.turnRight(gamepad2.left_trigger);
        robot.turnLeft(gamepad2.right_trigger);

//================================Diagonal Movement===============================================\\

        if (gamepad2.dpad_down) {
            robot.motor1.setPower(1);
            robot.motor2.setPower(0);
            robot.motor3.setPower(0);
            robot.motor4.setPower(1);
        } else if (gamepad2.dpad_up) {
            robot.motor1.setPower(-1);
            robot.motor2.setPower(0);
            robot.motor3.setPower(0);
            robot.motor4.setPower(-1);
        } else if (gamepad2.dpad_left) {
            robot.motor1.setPower(0);
            robot.motor2.setPower(1);
            robot.motor3.setPower(1);
            robot.motor4.setPower(0);
        } else if (gamepad2.dpad_right) {
            robot.motor1.setPower(0);
            robot.motor2.setPower(-1);
            robot.motor3.setPower(-1);
            robot.motor4.setPower(0);
        }

//=============================Dumb Stuff=========================================================\\

        if (gamepad2.y) {
            //move backwards
            robot.motor1.setPower(-1);
            robot.motor2.setPower(-1);
            robot.motor3.setPower(-1);
            robot.motor4.setPower(-1);
        } else if (gamepad2.a) {
            //move forward
            robot.motor1.setPower(1);
            robot.motor2.setPower(1);
            robot.motor3.setPower(1);
            robot.motor4.setPower(1);
        } else if (gamepad2.b) {
            //move left
            robot.motor1.setPower(1);
            robot.motor2.setPower(-1);
            robot.motor3.setPower(-1);
            robot.motor4.setPower(1);
        } else if (gamepad2.x) {
            //move right
            robot.motor1.setPower(-1);
            robot.motor2.setPower(1);
            robot.motor3.setPower(1);
            robot.motor4.setPower(-1);
        } else if (gamepad2.right_bumper) {
            //turn left
            robot.motor1.setPower(-1);
            robot.motor2.setPower(1);
            robot.motor3.setPower(-1);
            robot.motor4.setPower(1);
        } else if (gamepad2.left_bumper) {
            //turn right
            robot.motor1.setPower(1);
            robot.motor2.setPower(-1);
            robot.motor3.setPower(1);
            robot.motor4.setPower(-1);
        }
    }
}
