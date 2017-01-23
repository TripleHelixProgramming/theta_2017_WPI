package org.usfirst.frc.team2363.robot.commands.autonomous;

import java.util.Date;

import org.usfirst.frc.team2363.robot.Robot;

/**
 *
 */
public class TestGyroCommand extends DriveStraightCommand {

	private boolean hasTilted;
	private Date timer;
	
    public TestGyroCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(-.65, getCorrectedTurn());
    	hasTilted = hasTilted || Robot.drivetrain.isTilted(); 
    	
    	if (Robot.drivetrain.isTilted()) {
    		timer = null;
    	}
    	
    	if (hasTilted && !Robot.drivetrain.isTilted() && timer == null) {
    		timer = new Date();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer != null 
        		&& new Date().getTime() - timer.getTime() > 500;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
