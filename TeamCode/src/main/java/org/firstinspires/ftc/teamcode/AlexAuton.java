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
//========================================VARIABLES===============================================\\
//================================================================================================\\

//================================================================================================\\
        double red = robot.sensorColor.red();
        double green = robot.sensorColor.green();
        double blue = robot.sensorColor.blue();
//================================================================================================\\


//================================================================================================\\
//=====================================RANDOM CODE================================================\\
//================================================================================================\\
        /*
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

//=========================MORE RENDOM CODE=======================================================\\

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

//======================================COLOR SENSOR CODE=========================================\\

        while (red < 10)
            robot.moveForward(0.5);
 */

//===============================MORE COLOR SENSOR CODE===========================================\\
        robot.moveForward(0.3);
        while (robot.sensorColor.blue() <= 100) {
            continue;
        }
        while (robot.sensorColor.blue() > 100)
            continue;
        while (robot.sensorColor.blue() <= 100)
            continue;
        while (robot.sensorColor.blue() > 100)
            continue;
        while (robot.sensorColor.blue() < 100)
            robot.rest();

        robot.moveBackward(0.3);
        while (robot.sensorColor.blue() < 100)
            continue;
        while (robot.sensorColor.blue() > 100)
            continue;
        while (robot.sensorColor.red() < 100 == robot.sensorColor.blue() > 100 == robot.sensorColor.green() > 100)
            robot.rest();
//================================================================================================\\

        while (opModeIsActive() && runtime.milliseconds() < 30000) {
        }
    }
}