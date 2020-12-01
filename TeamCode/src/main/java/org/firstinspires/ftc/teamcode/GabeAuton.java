/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;
import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.UNNAMED;


@Autonomous(name="GabeAuton", group="Pushbot")
//@Disabled

public class GabeAuton extends LinearOpMode {
    private static final String TFOD_MODEL_ASSET = "UltimateGoal.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Quad";
    private static final String LABEL_SECOND_ELEMENT = "Single";
    private Anvil robot;
    private ElapsedTime runtime = new ElapsedTime();
    private static final String VUFORIA_KEY =
            "AXeANof/////AAABmaDs6FJl000DqMZb1GO2za8OTVHuQt7JKLF1cPYd4n6ToTb5uU19/BWc39F/bsNlzfVOalKd3tJdD3X42NYGDc/4PIfKaeWQG2Km+Ge8ueZcxkflgpLg/jjvxYAcJ7me0MM+j/5pJX1WQQLQCjrb2eXn8oCARcCsQeVq4VA0QtJOBvaE6Bvz3T8LS8c1CiJlb64sC5cS55824oq9RjtsYeWhbfh1uOV+hVg74AdwCu3VZC8CFJQNRKNL0ZPALv6PZWclrppxVESZF+aSYX5SIZln6C1iwvQskiJV2T4Xy45OP5PmO0vGW8P2r86+yG6y046AOeECsrLtLqonxWIpYXjnHvWpNgbarU/vPQgQET6i";
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;

    @Override
    public void runOpMode() {
        robot = new Anvil(hardwareMap, UNNAMED, telemetry);
        telemetry.addData("Status", "Initialized");
        runtime.reset();
        telemetry.update();

        waitForStart();

        while (robot.sensorColor.red() < 110){
            robot.moveForward(0.4);
            telemetry.addData("redSensor", robot.sensorColor.red());
            telemetry.update();
        }
        while (robot.sensorColor.red() < 110 && robot.sensorColor.blue() < 110 )
        robot.rest();

        while (opModeIsActive() && runtime.milliseconds() < 30000) {
            telemetry.addData("redSensor", robot.sensorColor.red());
            telemetry.update();

        }


    }
}
