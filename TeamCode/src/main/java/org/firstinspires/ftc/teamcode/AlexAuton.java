package org.firstinspires.ftc.teamcode;

//================================================================================================\\

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

//================================================================================================\\

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

        robot.moveLeft(1);
        sleep(1);
        robot.moveBackward(1);
        sleep(1);
        robot.moveRight(1);
        sleep(1);
        robot.moveForward(1);

//================================================================================================\\

        while (opModeIsActive() && runtime.milliseconds() < 2) {
        }
    }
}
