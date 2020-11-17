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
import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.UNNAMED;

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

        robot = new Anvil(hardwareMap, UNNAMED, telemetry);
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
/*
        robot.moveForward(d);
        sleep(3300);
        robot.rest();
        robot.moveForward(d);
        sleep(2200);
        robot.rest();
        robot.turnLeft(d);
        sleep(1000);
        robot.rest();
        robot.moveForward(d);
        sleep(1100);
        robot.rest();
        robot.turnLeft(d);
        sleep(1000);
        robot.rest();
        robot.moveForward(d);
        sleep(1100);
        robot.rest();
        robot.moveForward(d);
        sleep(4400);
        robot.rest();
        robot.turnLeft(d);
        sleep(2000);
        robot.rest();

 */

        double red = robot.sensorColor.red();
        double green = robot.sensorColor.green();
        double blue = robot.sensorColor.blue();


        robot.moveForward(0.5);

        while (red > 10)
            robot.rest();
//================================================================================================\\

        while (opModeIsActive() && runtime.milliseconds() < 30000) {
        }
    }
}
