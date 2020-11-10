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

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.EVAN;
import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;
import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.UNNAMED;


@Autonomous(name="AydenAuton", group="Pushbot")
//@Disabled

public class AydenAuton extends LinearOpMode {
    private Anvil robot;
    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        robot = new Anvil(hardwareMap, UNNAMED, telemetry);
        telemetry.addData("Status", "Initialized");
        runtime.reset();
        telemetry.update();
        waitForStart();


        robot.motor1.setPower(.6);
        robot.motor2.setPower(.6);
        robot.motor3.setPower(.6);
        robot.motor4.setPower(.6);
        robot.moveBackward(.5);
        sleep(1000);
        robot.moveForward(.5);
        sleep(2000);
        robot.moveBackward(.5);
        sleep(1000);
        robot.moveLeft(.5);
        sleep(1000);
                robot.moveRight(.5);
                sleep(2000);
                robot.moveForward(.5);
                sleep(1000);
                robot.moveLeft(.5);
                sleep(2000);
                robot.moveBackward(.5);
                sleep(2000);
                robot.moveRight(.5);
                sleep(2000);
                robot.moveForward(.5);
                sleep(1000);
                robot.moveRight(.5);
                sleep(1000);
                robot.motor1.setPower(.8);
                robot.motor2.setPower(0);
                robot.motor3.setPower(0);
                robot.motor4.setPower(0);
                robot.moveForward(.5);
                robot.motor1.setPower(0);
                robot.motor2.setPower(0);
                robot.motor3.setPower(0);
                robot.motor4.setPower(.8);
                robot.moveBackward(.5);
                sleep(20000);
                robot.rest();
















        while (opModeIsActive() && runtime.milliseconds() < 25000) {



        }


    }
}
