package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="MainTeleop", group="Pushbot")
//@Disabled
public class MainTeleop extends OpMode {

    private Anvil robot;

    @Override
    public void init(){
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.UNNAMED, telemetry);
    }
    double speed = 1;
    double speed2 = 1;
    boolean bool = true;
    boolean swap = true;
    boolean arm = false;
    @Override
    public void loop() {
        telemetry.addData("Speed",1/speed);
        telemetry.update();
        if (gamepad1.dpad_up){
            robot.liftClaw();
        }
        else if (gamepad1.dpad_down){
            robot.lowerClaw();
        }
        else if (gamepad1.dpad_left) robot.armServo.setPosition(1);

         if(gamepad1.a && swap) {
            bool = !bool;
            swap = false;
        } else swap = true;
        if (bool) {
            speed = 1;
        } else if (!bool) {
            speed = 2;
        }
        if (gamepad1.left_bumper && !arm) {
            robot.armMotor.setPower(1);
            arm = true;

        } else if (gamepad1.right_bumper) {
            robot.armMotor.setPower(-1);
        } else robot.armMotor.setPower(0);
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