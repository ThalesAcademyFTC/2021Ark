package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TylerTeleop", group="Pushbot")
//@Disabled
public class TylerTeleop extends OpMode {

    private Anvil robot;

    @Override
    public void init(){
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.UNNAMED, telemetry);
    }
    double speed = 1;
    double speed2 = 1;
    @Override
    public void loop() {

        if (gamepad1.left_bumper) {
            robot.turnLeft(speed2);
        } else if(gamepad1.right_bumper) {
            robot.turnRight(speed2);
        } else if(gamepad1.a) {
            speed = 1;
            speed2 = 1;
        } else if(gamepad1.b) {
            speed = 2;
            speed2 = 0.25;
        } else if(gamepad1.x) {
            speed = 3;
            speed2 = 0.5;
        } else if(gamepad1.y) {
            speed = 4;
            speed2 = 0.75;
        }

        if (gamepad1.atRest()) robot.rest();
        else {
            if (Math.abs(gamepad1.left_stick_x) + Math.abs(gamepad1.left_stick_y) > 1.3) {
                robot.moveDiagonal(gamepad1.left_stick_x, -gamepad1.left_stick_y, speed);
            } else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                robot.holoMoveLeft(gamepad1.left_stick_x / speed);
            } else if (Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.right_stick_y)) {
                robot.turnRight(gamepad1.right_stick_x / speed);
            } else robot.moveBackward(gamepad1.left_stick_y/speed);
        }
    }
}