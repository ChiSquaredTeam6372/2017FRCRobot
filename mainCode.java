package org.usfirst.frc.team6372.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
* The VM is configured to automatically run this class, and to call the
* functions corresponding to each mode, as described in the IterativeRobot
* documentation. If you change the name of this class or the package after
* creating this project, you must also update the manifest file in the resource
* directory.
*/
public class Robot extends IterativeRobot {
  RobotDrive myRobot = new RobotDrive(1, 2, 3, 4);
  RobotDrive climber = new RobotDrive(6, 5);
  Joystick stick = new Joystick(0);
  Timer timer = new Timer();
  XboxController xbc = new XboxController(1);
  //DriveTrain d = new DriveTrain();

  Spark left;
  Spark right;
  Spark left1;
  Spark right2;
  VictorSP climbr;
  VictorSP climbl;

  /**
  * This function is run when the robot is first started up and should be
  * used for any initialization code.
  */
  @Override
  public void robotInit() {
  }

  /**
  * This function is run once each time the robot enters autonomous mode
  */
  @Override
  public void autonomousInit() {
    timer.reset();
    timer.start();
  }

/**
* This function is called periodically during autonomous
*/
@Override
public void autonomousPeriodic() {
// Drive for 2 seconds
if (timer.get() &lt; 1.1) {
myRobot.drive(-0.55, 0.0); // drive forwards half speed
} else {
climber.drive(0.0, 0.0); // stop robot
}
}

  /**
  * This function is called once each time the robot enters tele-operated
  * mode
  */
  @Override
  public void teleopInit() {
  }

/**
* This function is called periodically during operator control
*/

@Override
public void teleopPeriodic() {

climber.drive(xbc.getRawAxis(3), 0);
climber.drive(xbc.getRawAxis(3), 0);
double forwardSpeed =

(Math.abs(stick.getRawAxis(Constants.JOYSTICK_LEFT_DRIVE_AXIS)) &lt; .2) ? 0 :
stick.getRawAxis(Constants.JOYSTICK_LEFT_DRIVE_AXIS);

double turnSpeed =

(Math.abs(stick.getRawAxis(Constants.JOYSTICK_TURN_DRIVE_AXIS)) &lt; .2) ? 0 :
stick.getRawAxis(Constants.JOYSTICK_TURN_DRIVE_AXIS);

drive(forwardSpeed,
forwardSpeed,
turnSpeed);

}

  public void drive(double left, double right, double turn, double climb) {
    climbl.set(-.5);
    climbr.set(.5);

  }

  /**
  * This function is called periodically during test mode
  */
  @Override
  public void testPeriodic() {
    LiveWindow.run();
  }

  public void drive(double left11, double right11, double turn11) {
    myRobot.setLeftRightMotorOutputs(left11 * Constants.MAX_DRIVE_SPEED + turn11 *

        Constants.MAX_TURN_SPEED,

        right11 * Constants.MAX_DRIVE_SPEED + -turn11 *

            Constants.MAX_TURN_SPEED);

  }
}
