package org.usfirst.frc.team6372.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.VictorSP;

public class DriveTrain {

  VictorSP left1;
  VictorSP left;
  VictorSP right1;
  VictorSP right;

  public void drive(double left11, double right11, double turn11) {
    left.set(left11 * Constants.MAX_DRIVE_SPEED + turn11 *

        Constants.MAX_TURN_SPEED);

    right.set(right11 * Constants.MAX_DRIVE_SPEED + turn11 *

        Constants.MAX_TURN_SPEED);

    left1.set(left11 * Constants.MAX_DRIVE_SPEED + turn11 *

        Constants.MAX_TURN_SPEED);

    right1.set(right11 * Constants.MAX_DRIVE_SPEED + turn11 *

        Constants.MAX_TURN_SPEED);
  }

}