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
    private final double ticksPerInchTurn = (43.95*.9)*1.3;
    private final double ticksPerInch = 43.95*.96;
    private double ticksDistance;
    private double ticksSoFar=0;
    private double startPos;
    private double arcDistance;
    private double baseDi = 24.6138172578;
    private double arcStartPos;
    private double arcTicksSoFar = 0;



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

    public void pointTurn(double angle, double power){
        arcDistance = (angle / 360.0) * baseDi * Math.PI;

        leftFront.setPower(power);
        rightFront.setPower(-power);
        leftRear.setPower(power);
        rightRear.setPower(-power);
        arcStartPos=leftFront.getCurrentPosition();

        while(arcTicksSoFar<arcDistance*ticksPerInchTurn){
            arcTicksSoFar= leftFront.getCurrentPosition()-arcStartPos;
        }

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftRear.setPower(0);
        rightRear.setPower(0);

        
    }
}
