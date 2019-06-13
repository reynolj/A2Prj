package com.mycompany.a2;

public class SteerableMissileLauncher extends MissileLauncher implements ISteerable {

	/**
	 * SteerableMissileLauncher constructor
	 * Gets default values from parent (MissileLauncher)
	 */
	public SteerableMissileLauncher() {
		super();
	}
	
	/*
	 * Turning right (clockwise) is a increase in the degree angle according to the specification.
	 * We can avoid having to check to see if we've gone above 359 degrees by adding 365 degrees and using mod 360.
	 * This will result in the direction to increase by 5 degrees.
	 * @see com.mycompany.a1.ISteerable#turnRight()
	 */
	public void turnRight() {
		this.setDirection((this.getDirection()+365) % 360);	// Add 359 and use mod 360 to ensure no negative numbers
		//System.out.println("Player Missile Launcher turned right. New direction: " + this.getDirection());
	}
	
	/*
	 * Turning left (counter clockwise) is an decrease in the degree angle according to the specification.
	 * We can avoid having to check to see if we've gone below 0 degrees by adding 355 and using mod 360.
	 * This will result in the direction to decrease by 5 degrees.
	 * @see com.mycompany.a1.ISteerable#turnLeft()
	 */
	public void turnLeft() {
		this.setDirection((this.getDirection()+355) % 360);	
		//System.out.println("Player Missile Launcher turned left. New direction: " + this.getDirection());
	}
}