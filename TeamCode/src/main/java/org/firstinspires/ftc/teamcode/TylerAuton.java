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

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.UNNAMED;


@Autonomous(name="TylerAuton", group="Pushbot")
//@Disabled

public class TylerAuton extends LinearOpMode {
    private Anvil robot;
    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        robot = new Anvil(hardwareMap, UNNAMED, telemetry);
        telemetry.addData("Status", "Initialized");
        runtime.reset();
        telemetry.update();
        waitForStart();

        // square a right starting position
        /*while ( robot.sensorColor.red() < 100) {
            robot.moveRight(0.3);
        }
        robot.moveRightFT(1000);*/


        //square a left starting position
        /*while (robot.sensorColor.red() < 100 || robot.sensorColor.green() < 200 || robot.sensorColor.blue() < 200) {
            robot.moveForward(0.5);
        }
        while (robot.sensorColor.red() >= 100 || robot.sensorColor.green() >= 200|| robot.sensorColor.blue() >= 200) continue;

        while (robot.sensorColor.red() < 100) {
            robot.moveForward(0.5);
        }
        robot.moveForwardFT(1000); */


        //square b right starting position
        /*robot.moveRight(0.3);
        while (robot.sensorColor.red() < 100) {
            continue;
        }
        while (robot.sensorColor.red() >= 100) continue;

        while (robot.sensorColor.red() < 100 || robot.sensorColor.green() < 200|| robot.sensorColor.blue() < 200) {
            continue;
        }
        while (robot.sensorColor.red() >= 100 || robot.sensorColor.green() >= 200|| robot.sensorColor.blue() >= 200) continue;

        while (robot.sensorColor.red() < 100) {
            continue;
        }
        robot.moveRightFT(1000);*/

        //square b left starting position
        /*robot.moveForward(0.5);
        while (robot.sensorColor.red() < 100 || robot.sensorColor.blue() < 200 || robot.sensorColor.green() < 200) {
            continue;
        }
        while (robot.sensorColor.red() < 100 || robot.sensorColor.blue() < 200 || robot.sensorColor.green() < 200) continue;

        while (robot.sensorColor.red() < 100) {
            continue;
        }

        robot.moveForwardFT(1000);*/

        //square c right starting position
        /*robot.moveRight(0.3);
        while (robot.sensorColor.red() < 100) continue;

        while (robot.sensorColor.red() > 100) continue;

        while (robot.sensorColor.red() < 100 || robot.sensorColor.green() < 200 || robot.sensorColor.blue() < 200) continue;

        while (robot.sensorColor.red() >= 100 || robot.sensorColor.green() >= 200 || robot.sensorColor.blue() >= 200) continue;

        while (robot.sensorColor.red() < 100) continue;

        while (robot.sensorColor.red() > 100) continue;

        while (robot.sensorColor.red() < 100) continue;

        while (robot.sensorColor.red() > 100) continue;

        robot.moveForwardFT(1000);*/

        //square c left starting position
        /*robot.moveForward(0.3);
        while (robot.sensorColor.red() < 100 || robot.sensorColor.blue() < 200 || robot.sensorColor.green() < 200) continue;

        while (robot.sensorColor.red() >= 100 || robot.sensorColor.blue() >= 200 || robot.sensorColor.green() >= 200) continue;

        while (robot.sensorColor.red() < 100) continue;

        while (robot.sensorColor.red() < 100) continue;

        while (robot.sensorColor.red() > 100) continue; */

        //square a left start position
        robot.moveForward(0.3);
        while (robot.sensorColor.blue() < 100       ) {
            continue;
        }
        robot.moveLeftFT(500);
        robot.moveForwardFT(500);

        //square a right starting position
        //robot.moveForward(0.3);


        //square b left starting position
        /*robot.moveForward(0.3);

        while (robot.sensorColor.red() < 100 || robot.sensorColor.blue() < 200 || robot.sensorColor.green() < 200) continue;

        while (robot.sensorColor.red() > 100 || robot.sensorColor.blue() > 200 || robot.sensorColor.green() > 200) continue;

        while (robot.sensorColor.blue() < 100) continue;

        robot.moveForwardFT(500);

        robot.turnLeftFT(500, 0.3);

        while (robot.sensorColor.blue() < 100) {
            robot.moveForward(0.3);
        }*/

        //square c left starting position
        /*robot.moveForward(0.3);

        while (robot.sensorColor.red() < 100 || robot.sensorColor.blue() < 200 || robot.sensorColor.green() < 200) continue;

        while (robot.sensorColor.red() > 100 || robot.sensorColor.blue() > 200 || robot.sensorColor.green() > 200) continue;

        while (robot.sensorColor.blue() < 100) continue;

        while (robot.sensorColor.blue() > 100) continue;

        while (robot.sensorColor.blue() < 100) continue;

        while (robot.sensorColor.blue() > 100) continue;

        robot.moveForwardFT(500);*/

        while (opModeIsActive() && runtime.milliseconds() < 30000) {

        }
    }
}