package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by dcrenshaw on 4/7/19.
 * Clasp is a basic, bare-bones teleop designed to run on top of Anvil.
 */

@TeleOp(name="AGTeleop", group="Pushbot")
//@Disabled
public class AGTeleop extends OpMode {

    private Anvil robot;

    @Override
    public void init() {
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
    }

    @Override
    public void loop() {
        if (gamepad1.atRest()) robot.rest();
        else {
            if (gamepad1.right_bumper) {
                robot.motor1.setPower(.8);
                robot.motor4.setPower(.8);
            } else if (gamepad1.left_bumper)  {
                robot.motor2.setPower(.8);
                robot.motor3.setPower(.8);
            } else if (gamepad1.left_stick_y > 0.5){
                robot.moveForward(1);
            } else if (gamepad1.left_stick_x > 0.5){
                robot.moveRight(1);
            } else if (gamepad1.left_stick_y < -0.5){
                robot.moveBackward(1);
            } else if (gamepad1.left_stick_x < -0.5){
                robot.moveLeft(1);
            } else if (gamepad1.right_stick_x > 0.5){
                robot.turnRight(.75);
            } else if (gamepad1.right_stick_x < -0.5){
                robot.turnLeft(.75);
            }
        }
    }
}
