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

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;
import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.UNNAMED;


@Autonomous(name="RedCornerAuton", group="Pushbot")
//@Disabled

public class RedCornerAuton extends LinearOpMode {
    private static final String TFOD_MODEL_ASSET = "UltimateGoal.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Quad";
    private static final String LABEL_SECOND_ELEMENT = "Single";
    private Anvil robot;
    private ElapsedTime runtime = new ElapsedTime();
    private static final String VUFORIA_KEY =
            "AXeANof/////AAABmaDs6FJl000DqMZb1GO2za8OTVHuQt7JKLF1cPYd4n6ToTb5uU19/BWc39F/bsNlzfVOalKd3tJdD3X42NYGDc/4PIfKaeWQG2Km+Ge8ueZcxkflgpLg/jjvxYAcJ7me0MM+j/5pJX1WQQLQCjrb2eXn8oCARcCsQeVq4VA0QtJOBvaE6Bvz3T8LS8c1CiJlb64sC5cS55824oq9RjtsYeWhbfh1uOV+hVg74AdwCu3VZC8CFJQNRKNL0ZPALv6PZWclrppxVESZF+aSYX5SIZln6C1iwvQskiJV2T4Xy45OP5PmO0vGW8P2r86+yG6y046AOeECsrLtLqonxWIpYXjnHvWpNgbarU/vPQgQET6i";
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;
    private String lastRecognized;

    @Override
    public void runOpMode() {
        robot = new Anvil(hardwareMap, UNNAMED, telemetry);
        telemetry.addData("Status", "Initialized");

        initVuforia();
        initTfod();

        if (tfod != null) {
            tfod.activate();
            tfod.setZoom(2.5, 1.78);
        }

        runtime.reset();
        telemetry.update();

        waitForStart();
        robot.moveForwardFT(2200, 0.5); //Line robot up with disks
        robot.turnLeftFT(1350, 0.5); //Turn towards Disks, depends on where camera is located

        // Checks for disks
        if (opModeIsActive()) {
            while (opModeIsActive() && runtime.milliseconds() < 7000) {
                if (tfod != null) {
                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                        // step through the list of recognitions and display boundary info.
                        int i = 0;
                        for (Recognition recognition : updatedRecognitions) {
                            lastRecognized = recognition.getLabel();
                        }
                    }
                }
            }
            if (tfod != null) {
                tfod.shutdown();
            }

        }
        if (lastRecognized == "Quad"){
            //Position C
            robot.moveForward(.3);
            for (int i=0; i<3; i++) {
                while (robot.sensorColor.red() <= 100) continue;
                while (robot.sensorColor.red() > 100) continue;
            }

            while (robot.sensorColor.red() <= 100) continue;

            robot.moveBackward(.3);

            while (robot.sensorColor.red() < 100 || robot.sensorColor.blue() < 200 || robot.sensorColor.green() < 200) continue;

            if (robot.sensorColor.red() > 100 || robot.sensorColor.blue() > 200 || robot.sensorColor.green() > 200) robot.rest();

        } else if (lastRecognized == "Single"){
            //Position B
            //Turn to position arm facing the blue side of field
            robot.turnLeftFT(800, 0.5);

            robot.moveBackward(0.5);
            //Checking for red line.
            while (robot.sensorColor.red() < 100) continue;
            while (robot.sensorColor.red() >= 100) continue;

            //Checking for white line
            while (robot.sensorColor.red() < 100 || robot.sensorColor.blue() < 200 || robot.sensorColor.green() < 200) continue;
            while (robot.sensorColor.red() > 100 || robot.sensorColor.blue() > 200 || robot.sensorColor.green() > 200) continue;
            while (robot.sensorColor.red() < 100) continue;

            robot.moveRight(0.3);

            while (robot.sensorColor.red() < 100) continue;
            robot.moveLeftFT(800);

            robot.moveForward(0.5);
            while (robot.sensorColor.red() < 100 || robot.sensorColor.blue() < 200 || robot.sensorColor.green() < 200) continue;
            robot.rest();
        } else {
            //Position A
            robot.moveRight(0.3);
            while (robot.sensorColor.red() < 100 || robot.sensorColor.blue() < 200 || robot.sensorColor.green() < 200) continue;
            robot.moveLeftFT(800);

            robot.moveRight(0.3);
            while (robot.sensorColor.red() < 100 || robot.sensorColor.blue() < 200 || robot.sensorColor.green() < 200) continue;
            robot.rest();
        }


        while (opModeIsActive() && runtime.milliseconds() < 30000) {
            telemetry.addData("lastRecognized", lastRecognized);
            telemetry.update();
        }
    }
    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

    /**
     * Initialize the TensorFlow Object Detection engine.
     */
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.8f;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
    }
}
