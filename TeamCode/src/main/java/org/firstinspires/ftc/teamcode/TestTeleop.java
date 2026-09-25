package org.firstinspires.ftc.teamcode;

import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.ManualDrive;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.pedro.Constants;

@TeleOp (name = "Test Teleop")
public class TestTeleop extends OpMode {
    Follower follower;
    KestrelLauncher launcher;

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
        launcher.init(hardwareMap);

    }

    @Override
    public void loop() {
        // DRIVING
        ManualDrive.driveOrHold(
                follower,
                -gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                gamepad1.right_stick_x
        );
        Pose robotPose = follower.pose();

        launcher.update(1);

        // TELEMETRY
        telemetry.addData("Robot X", robotPose.x());
        telemetry.addData("Robot Y", robotPose.y());
        telemetry.addData("Robot Heading", Math.toDegrees(robotPose.heading()));

        // UPDATE
        follower.update();
        telemetry.update();
    }

    // Any additional methods go here

}