package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
    private Chassis chassis;
    private Telemetry telemetry;
    private HardwareMap hardwareMap;


    public Robot(Telemetry telemetry, HardwareMap hardwareMap){
        this.telemetry=telemetry;
        this.hardwareMap=hardwareMap;
        chassis=new Chassis(telemetry, hardwareMap);
    }



    public void driveStraight(double distance){
        chassis.driveStraight(distance);

    }

    public void pointTurn(double angle, double power){
        chassis.pointTurn(angle, power);
    }
}
