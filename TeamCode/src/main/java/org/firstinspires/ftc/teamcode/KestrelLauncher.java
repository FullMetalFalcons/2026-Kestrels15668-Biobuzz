package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class KestrelLauncher {
    DcMotorEx motorLaunch;
    public static double launcher_p = 0, launcher_f = 0;

    public void init(HardwareMap hwMap) {
        motorLaunch = (DcMotorEx) hwMap.dcMotor.get("launch");
        motorLaunch.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLaunch.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorLaunch.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLaunch.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorLaunch.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,
                new PIDFCoefficients(launcher_p, 0, 0, launcher_f));
    }

    public void update(double velocity) {
        motorLaunch.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,
                new PIDFCoefficients(launcher_p, 0, 0, launcher_f));
        motorLaunch.setVelocity(velocity);
    }
}
