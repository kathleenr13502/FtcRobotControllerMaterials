package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a four wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */
@Autonomous(name="katie: intro", group="Iterative Opmode")
//@Disabled
public class Auto extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront = null;
    private DcMotor leftRear = null;
    private DcMotor rightFront = null;
    private DcMotor rightRear = null;

    @Override
    public void runOpMode(){

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).

        leftFront = hardwareMap.get(DcMotor.class, "front_left_motor");
        leftRear = hardwareMap.get(DcMotor.class, "back_left_motor");
        rightFront = hardwareMap.get(DcMotor.class, "front_right_motor");
        rightRear = hardwareMap.get(DcMotor.class, "back_right_motor");
        waitForStart();
        runtime.reset();
        Robot robot=new Robot(telemetry, hardwareMap);

        /*while(opModeIsActive()) {
            telemetry.addData("Left Front Encoder", leftFront.getCurrentPosition());
            telemetry.update();
        }*/
        robot.pointTurn(90);


    }
}
