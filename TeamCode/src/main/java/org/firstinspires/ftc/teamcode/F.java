package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;

public class F {
    //Define servo and motor variables
    public DcMotor motor1, motor2, motor3, motor4, cmotor1, cmotor2;
    DigitalChannel touchyBlock, touchSensor;
    ColorSensor sensorColor;
    public CRServo crservo1;
    public Servo servo1, rservo1, rservo2, skyServo;
    public DcMotor clawMotor, armMotor;
    public OpenGLMatrix lastLocation = null;
    int[] positions = {650, 4600, 5200};
    int target = positions[0];

    //Reference to mapped servo/motor controller
    private HardwareMap hwMap;

    public Telemetry telemetry;

    public DcMotor[] forward, right, left, special, unique, collect;

    private double ticksPerInch = 15.26;

    public boolean hs = true;

    public enum Drivetrain {
        HOLONOMIC,
        MECHANUM,
        UNNAMED,
        TANK,
        WEST_COAST,
        OMNIDRIVE,
        EVAN,
        SAM,
        KARL
    }
    public enum direction {
        TR,
        TL,
        BR,
        BL,
    }

    public F(HardwareMap ahwMap, Anvil.Drivetrain type, Telemetry telem) {
        hwMap = ahwMap;

        telemetry = telem;

        //Each of these cases are for different drive trains, the setup for each drive train is within.
        switch (type) {
            /*Example drive train:
            case TRAIN_NAME: //Make sure TRAIN_NAME is in the types enum!
                //Map all motors to proper variables.
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                //Set motor directions. These should all be set so that power 1 for all
                //motors == robot moves forwards.
                motor1.setDirection(DcMotor.Direction.REVERSE);
                motor2.setDirection(DcMotor.Direction.FORWARD);
                //Set motor purposes for maneuvers. Motors in 'right' are the motors which must
                //move in reverse for the robot to turn right, and the same applies for left.
                //'forward' should contain all motors.
                forward = new DcMotor[]{motor1, motor2};
                right = new DcMotor[]{motor1};
                left = new DcMotor[]{motor2};
                //There is also a "special" motor array which is used for any additional
                //nonsense you want to do with the robot. Right now, it's just used for
                //holonomic and mechanum special movements.
                break;
             */
            case UNNAMED:
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                motor1.setDirection(DcMotor.Direction.REVERSE);
                motor2.setDirection(DcMotor.Direction.FORWARD);
                motor3.setDirection(DcMotor.Direction.FORWARD);
                motor4.setDirection(DcMotor.Direction.REVERSE);
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                right = new DcMotor[]{motor2, motor4};
                left = new DcMotor[]{motor1, motor3};
                special = new DcMotor[]{motor1, motor4};
                unique = new DcMotor[]{motor2, motor3};
                break;
            default:
                telemetry.addLine("Invalid type " + type + " passed to Anvil's init function. Nothing has been set up.");
                break;
        }
        if (forward != null) {
            for (DcMotor x : forward) {
                x.setPower(0);
                x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }
        }
    }
    public void mf(double speed){
        motor1.setPower(speed);
        motor2.setPower(speed);
        motor3.setPower(speed);
        motor4.setPower(speed);
    }
    public void mb(double speed){
       motor1.setPower(-speed);
       motor2.setPower(-speed);
       motor3.setPower(-speed);
       motor4.setPower(-speed);
    }
    public void mr(double speed){
        motor1.setPower(speed);
        motor4.setPower(speed);
    }
    public void ml(double speed) {
        motor2.setPower(speed);
        motor3.setPower(speed);
    }
    public void dtr(double speed) {
        motor2.setPower(speed);
        motor3.setPower(speed);
    }
    public void dtl(double speed) {
        motor1.setPower(speed);
        motor4.setPower(speed);
    }
    public void dbl(double speed){
        motor3.setPower(-speed);
        motor2.setPower(-speed);
    }
    public void dbr(double speed){
        motor1.setPower(-speed);
        motor4.setPower(-speed);
    }
    public void say(String word){
        System.out.println(word);
    }
    public void say(int num){
        System.out.println(num);
    }
    public void add(int a,int b){
        say(a + b);
    }
    public void sub(int c, int d){
        say(c + d);
    }
}
