package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Chassis {
    private DcMotor leftFront = null;
    private DcMotor leftRear = null;
    private DcMotor rightFront = null;
    private DcMotor rightRear = null;
    private Telemetry telemetry;
    private HardwareMap hardwareMap;
    private final double ticksPerInch = 43.95*.94;
    private double ticksDistance;
    private double ticksSoFar=0;
    private double startPos;
    private double arcDistance;
    private double baseRad = 24.6138172578/2;
    private double arcStartPos;
    private double arcTicksSoFar=0;



    public Chassis(Telemetry telemetry, HardwareMap hardwareMap) {
        this.telemetry = telemetry;
        leftFront = hardwareMap.get(DcMotor.class, "front_left_motor");
        leftRear = hardwareMap.get(DcMotor.class, "back_left_motor");
        rightFront = hardwareMap.get(DcMotor.class, "front_right_motor");
        rightRear = hardwareMap.get(DcMotor.class, "back_right_motor");

        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        rightRear.setDirection(DcMotor.Direction.FORWARD);
    }

    public void driveStraight(double distance){
        ticksDistance=ticksPerInch*distance;
        leftFront.setPower(.2);
        rightFront.setPower(.2);
        leftRear.setPower(.2);
        rightRear.setPower(.2);

        startPos=leftFront.getCurrentPosition();
        while(ticksSoFar<ticksDistance){
            ticksSoFar= leftFront.getCurrentPosition()-startPos;

        }
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftRear.setPower(0);
        rightRear.setPower(0);

    }

    public void pointTurn(double angle){
        arcDistance = (angle / 360.0) * baseRad * Math.PI;

        leftFront.setPower(.2);
        rightFront.setPower(-.2);
        leftRear.setPower(.2);
        rightRear.setPower(-.2);
        arcStartPos=leftFront.getCurrentPosition();

        while(arcTicksSoFar<arcDistance*ticksPerInch){
            arcTicksSoFar= leftFront.getCurrentPosition()-arcStartPos;
        }

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftRear.setPower(0);
        rightRear.setPower(0);
    }
}
