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
    boolean bool, bbool, cbool = true;
    boolean aswap, bswap, cswap = true;
    boolean arm = true;
    @Override
    public void loop() {
        telemetry.addData("Speed",1/speed);
        telemetry.addData("arm",arm);
        telemetry.addData("arm position",robot.armMotor.getCurrentPosition());
        telemetry.update();
        if (gamepad1.dpad_up){
            robot.liftClaw();
        }
        else if (gamepad1.dpad_down){
            robot.lowerClaw();
        }
        else if (gamepad1.dpad_left) robot.armServo.setPosition(1);

        if(gamepad1.a && aswap) {
            bool = !bool;
            aswap = false;
        } else aswap = true;
        if (bool) {
            speed = 1;
        } else if (!bool) {
            speed = 2;
        }
        //code for using button to move claw to precise position while robot is moving.
        if (!arm) {
            if (robot.armMotor.getCurrentPosition() > 10500) arm = true;
        }

        if (gamepad1.left_bumper && arm){
            robot.armMotor.setPower(1);
            arm = false;
        } else if (gamepad1.right_bumper){
            robot.armMotor.setPower(-1);
            arm = true;
        } else if (arm) robot.armMotor.setPower(0);

        //Code for loading and firing the mechanism
        if(gamepad1.left_trigger > 0.5 && bswap) {
            bbool = !bbool;
            bswap = false;
        } else bswap = true;
        if (bbool) {
            robot.cmotor1.setPower(0);
        } else if (!bbool) {
            robot.fireRing();
        }
        if(gamepad1.right_trigger > 0.5 && cswap) {
            cbool = !cbool;
            cswap = false;
        } else cswap = true;
        if (cbool) {
            robot.cmotor1.setPower(0);
        } else if (!cbool) {
            robot.collectRing();
        }

        //Code for raising and lowering the ramp along with set positions
        if (gamepad1.x) robot.loadRamp();
        else if(gamepad1.y) robot.halframp();
        else if (gamepad1.b) robot.highramp();


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