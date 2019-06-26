package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class PlayerShip extends Ship implements ISteerable{
	private static PlayerShip PS = null;
	private SteerableMissileLauncher steerableMissileLauncher;
	
	/**
	 * PlayerShip private constructor
	 * Gets default attributes like location, direction and speed from parent object.
	 * Sets location to center of screen, color, speed, direction and missile count.
	 */
	private PlayerShip() {
		super();
		this.setColor(ColorUtil.rgb(0,0,255));
		this.steerableMissileLauncher = new SteerableMissileLauncher();
		this.steerableMissileLauncher.setColor(this.getColor());
		// Resets PlayerShip and MissileLauncher
		this.resetPlayerShip();
	}
	
	/**
	 * This method is required to create an instance of PlayerShip.
	 * If one already exists, returns the existing object.
	 * @return PlayerShip Object
	 */
	public static PlayerShip getInstance() {
		if (PS == null)
			PS = new PlayerShip();
		return PS;
	}
	
	///////////////////////////PlayerShip Helper Functions/////////////////////////
	
	/**
	 * Returns a boolean to let us know if a PlayerShip exists or not.
	 * @return True if PlayerShip doesn't exist, False if it does.
	 */
	public static boolean isMissing() {
		return PS == null ? true : false;
	}
	
	/**
	 * Removes a PlayerShip object from our object holder.
	 * Useful for knowing whether or not a PlayerShip exists.
	 */
	public static void deleteShip() {
		PS = null;
	}
	
	/**
	 * Resets the position of the player ship and its missile launcher to the center of the game board
	 * This is primarily used when respawning the PlayerShip after it dies.
	 * @param PS PlayerShip object
	 */
	public void resetPlayerShip() {
		this.setLocation(GameWorld.getWidth(), GameWorld.getHeight());
		this.setSpeed(INIT_SPEED_PS);
		this.setDirection(INIT_DIR_PS);
		this.setMissileCount(INIT_M_PS);
		this.steerableMissileLauncher.setLocation(GameWorld.getWidth(), GameWorld.getHeight());
		this.steerableMissileLauncher.setSpeed(INIT_SPEED_PS);
		this.steerableMissileLauncher.setDirection(INIT_DIR_PS);
	}
	
	/**
	 * Reloads the missile count for PlayerShip
	 */
	public void reloadMissiles() {
		PS.setMissileCount(INIT_M_PS);
	}
	
	///////////////////////////End PlayerShip Helper Functions/////////////////////
	
	///////////////////////////PlayerShip Movement Methods/////////////////////////
	
	/**
	 * Increases PS speed to current speed + SPEED_DELTA 
	 */
	public boolean increaseSpeed() {
		if ( PS.getSpeed() + SPEED_DELTA <= MAX_SPEED)
		{
			 PS.setSpeed( PS.getSpeed() + SPEED_DELTA );
			 this.steerableMissileLauncher.setSpeed(this.getSpeed());
			 return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Decreases PS speed to current speed - SPEED_DELTA
	 */
	public boolean decreaseSpeed() {
		if ( PS.getSpeed() - SPEED_DELTA >= MIN_SPEED)
		{
			 PS.setSpeed( PS.getSpeed() - SPEED_DELTA );
			 this.steerableMissileLauncher.setSpeed(this.getSpeed());
			 return true;
		} else {
			return false;
		}
	}

	/**
	 * Turning right (clockwise) is a increase in the degree angle according to the specification.
	 * We can avoid having to check to see if we've gone above 359 degrees by adding 365 degrees and using mod 360.
	 * This will result in the direction to increase by 5 degrees.
	 * The missile launcher's direction will change with the ships direction, aswell.
	 * @see com.mycompany.a1.ISteerable#turnRight()
	 */
	public void turnRight() {
		this.setDirection((this.getDirection()+365) % 360);
		this.steerableMissileLauncher.turnRight();
	}
	
	/**
	 * Turning left (counter clockwise) is an decrease in the degree angle according to the specification.
	 * We can avoid having to check to see if we've gone below 0 degrees by adding 355 and using mod 360.
	 * This will result in the direction to decrease by 5 degrees.
	 * The missile launcher's direction will change with the ships direction, aswell.
	 * @see com.mycompany.a1.ISteerable#turnLeft()
	 */
	public void turnLeft() {
		this.setDirection((this.getDirection()+355) % 360);	
		this.steerableMissileLauncher.turnLeft();
	}
	
	/**
	 * Jumps ship to hyperspace. PlayerShip's location resets to the center of the GameWorld.
	 * The SteerableMissileLauncher's location is also updated.
	 * 
	 * This method is different from ResetPlayerShip in that it does not affect the speed
	 * of the PlayerShip or Launcher.
	 */
	public void jump() {
		this.setLocation(CENTER_X, CENTER_Y);
		this.steerableMissileLauncher.setLocation(CENTER_X, CENTER_Y);
	}
	
	///////////////////////////End PlayerShip Movement Methods/////////////////////

	////////////SteerableMissileLauncher Movement and Helper Methods///////////////
	
	/**
	 * Turns missile launcher left.
	 * Implements ISteerable
	 */
	public void turnLauncherLeft() {
		PS.steerableMissileLauncher.turnLeft();
	}
	
	/**
	 * Turns missile launcher right.
	 * Implements ISteerable
	 */
	public void turnLauncherRight() {
		PS.steerableMissileLauncher.turnRight();
	}

	/**
	 * Sets the SteerableMissileLauncher's new location after move.
	 */
	public void setMLLocation() {
		steerableMissileLauncher.setLocation(this.getLocation().getX(), this.getLocation().getY());
	}
	
	/**
	 * Returns direction of PlayerShip missile launcher
	 * @return direction (int 0-359)
	 */
	public int getLauncherDirection() {
		return PS.steerableMissileLauncher.getDirection();
	}
	
	////////////End SteerableMissileLauncher Movement and Helper Methods////////////
	
	/**
	 * toString override method
	 */
	public String toString() {
		String parentDesc = super.toString();
		String localDesc = " Missile launcher dir = " + this.getLauncherDirection();
		String header = "Player Ship: ";
		
		return header + parentDesc + localDesc;
	}
	
}