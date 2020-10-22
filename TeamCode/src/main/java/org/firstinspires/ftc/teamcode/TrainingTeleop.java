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
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
    }

    @Override


    public void loop() {
        telemetry.addData("encoder1", robot.motor1.getCurrentPosition());
        telemetry.addData("encoder2", robot.motor2.getCurrentPosition());
        telemetry.addData("encoder3", robot.motor3.getCurrentPosition());
        telemetry.addData("encoder4", robot.motor4.getCurrentPosition());
        telemetry.update();
        if (gamepad1.x){
            robot.motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            robot.motor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            robot.motor3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            robot.motor4.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        if (gamepad1.atRest()) robot.rest();
        else {
            if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                robot.turnRight(gamepad1.left_stick_x);
            } else robot.moveBackward(gamepad1.left_stick_y);
        }

    }
}