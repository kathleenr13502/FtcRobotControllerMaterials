package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {

    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private Chassis chassis;
    private SpinningArm spinningArm;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        chassis = new Chassis(hardwareMap,telemetry);
        spinningArm = new SpinningArm(hardwareMap, telemetry);
    }

    void driveStraight(double distance){
        chassis.driveStraight(distance);

    }
    void pointTurn(double angle,boolean rightTurn) {
        chassis.pointTurn(angle,rightTurn);
    }
    void spin(){
        spinningArm.spin();
    }

}