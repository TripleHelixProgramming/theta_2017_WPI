package org.usfirst.frc.team2363.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2363.robot.Robot.drivetrain;
import static org.usfirst.frc.team2363.robot.Robot.oi;


/**
 *
 */
public class JoystickDrive extends Command {

    public JoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drivetrain);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.arcadeDrive(oi.getThrottle(), oi.getTurn());
//    	if (Math.abs(Robot.oi.getThrottle()) > 0.1
//    			|| Math.abs(Robot.oi.getTurn()) > 0.1
////    			|| Robot.drivetrain.isLeftMoving()
//    			|| Robot.drivetrain.isRightMoving()) {
//    		Robot.drivetrain.brakeDisengage();
//    	} else {
//    		Robot.drivetrain.brakeEngage();
//    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
