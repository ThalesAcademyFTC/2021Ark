package org.firstinspires.ftc.teamcode;

//================================================================================================\\

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

//================================================================================================\\

import org.firstinspires.ftc.robotcore.internal.camera.libuvc.api.UvcApiCameraCaptureRequest;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.EVAN;
import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;

//================================================================================================\\

@Autonomous(name="AlexAuton", group="Pushbot")
//@Disabled

//================================================================================================\\

public class AlexAuton extends LinearOpMode {
    private Anvil robot;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

//================================================================================================\\

        robot = new Anvil(hardwareMap, MECHANUM, telemetry);
        telemetry.addData("Status", "Initialized");
        runtime.reset();
        telemetry.update();
        waitForStart();

//================================================================================================\\
        double a = 1.0;
        double b = 0.9;
        double c = 0.8;
        double d = 0.7;
        double e = 0.6;
        double f = 0.5;
        double g = 0.4;
        double h = 0.3;
        double i = 0.2;
        double j = 0.1;
        int z = 1100;
        int y = 2200;
        int x = 3300;


/*        robot.moveLeft(a);
        sleep(3300);
        robot.rest();
        robot.moveBackward(a);
        sleep(6600);
        robot.rest();
        robot.moveRight(a);
        sleep(3300);
        robot.rest();
        robot.moveForward(a);
        sleep(6600);
        robot.rest();
        robot.moveLeft(a);
        sleep(3300);
        robot.rest();
        robot.moveBackward(a);
        sleep(6600);
        robot.rest();
        robot.moveRight(a);
        sleep(3300);
        robot.rest();
        robot.moveForward(a);
        sleep(6600);
        robot.rest();
        /*

 */
        robot.moveForward(a);
        sleep(3300);
        robot.rest();
        robot.moveForward(a);
        sleep(2200);
        robot.rest();
        robot.turnLeft(a);
        sleep(1000);
        robot.rest();
        robot.moveForward(a);
        sleep(1100);
        robot.rest();
        robot.turnLeft(a);
        sleep(1000);
        robot.rest();
        robot.moveForward(a);
        sleep(1100);
        robot.rest();
        robot.moveForward(a);
        sleep(4400);
        robot.rest();
        robot.turnLeft(a);
        sleep(2000);
        robot.rest();

//================================================================================================\\

        while (opModeIsActive() && runtime.milliseconds() < 30000) {
        }
    }
}
