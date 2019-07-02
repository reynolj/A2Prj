package com.mycompany.a2.gameobjects;

import com.mycompany.a2.GameWorld;
import com.mycompany.a2.interfaces.IMoveable;

public abstract class MoveableGameObject extends GameObject implements IMoveable {
	private int speed;		
	private int direction;
	
	/**
	 * MoveableGameObject constructor
	 */
	public MoveableGameObject() {
		super();
		this.speed = R.nextInt(MAX_SPEED + 1);
		this.direction = R.nextInt(MAX_DIR + 1);
	}
	
	//*******************************Getter Methods******************************************//
	
	/**
	 * Returns the direction of the MoveableObject
	 * @return direction (int 0-359)
	 */
	public int getDirection() {
		return direction;
	}
	/**
	 * Returns the speed of the MoveableObject
	 * @return speed (int)
	 */
	public int getSpeed() {
		return speed;
	}
	
	//*******************************End of Getter Methods***********************************//
	
	
	//*******************************Setter Methods******************************************//
	
	/**
	 * Sets the direction of the MoveableObject
	 * @param _direction
	 */
	public void setDirection(int _direction) {
		direction = _direction;
	}
	
	/**
	 * Sets the speed of the MoveableObject
	 * @param _speed
	 */
	public void setSpeed(int _speed) {
		speed = _speed;
	}
	
	//*******************************End of Getter Methods***********************************//

	/**
	 * toString override method
	 */
	@Override
	public String toString() {
		String parentDesc = super.toString();
		String localDesc = " speed = " + this.getSpeed() +
				  		   " dir = " + this.getDirection();
		
		return parentDesc + localDesc;
	}
	
	/**
	 * Moves the MoveableObjects
	 * First, we translate the direction into a mathematically accurate direction in degrees.
	 * We then get the new individual x and y coordinates by changing the degrees to radians and multiplying 
	 * by the speed of the object.
	 * Finally we insure the object stays on the game board by adding the maximum coordinate and modding by 
	 * the maximum coordinate.
	 * 
	 * We can only directly move MoveableObjects, but we CANNOT directly move the SteerableMissileLauncher.
	 */
	public void move(int time) {
		if (this instanceof SteerableMissileLauncher) {
			//Don't move the SteerableMissileLauncher directly.
			//It's direction is not the direction of movement.
			//It's movement is based on the movement of PlayerShip.
			//PlayerShip will update the location of SteerableMissileLauncher.
		} else {
			int myDirection = (90 - (this.getDirection()));	// gets the true degrees using proper math representation.
			double newX = this.getLocation().getX() + (Math.cos(Math.toRadians(myDirection)) * ((double) this.getSpeed() * ((double) time/100)));
			double newY = this.getLocation().getY() + (Math.sin(Math.toRadians(myDirection)) * ((double) this.getSpeed() * ((double) time/100)));
			newX = (newX + GameWorld.getWidth()) % GameWorld.getWidth();					// using mod to have object pop up on the other side of the game board.
			newY = (newY + GameWorld.getHeight()) % GameWorld.getHeight();					// using mod to have object pop up on the other side of the game board.
			this.setLocation(newX, newY);
			
			// If this is a NPS, we need to update it's missileLauncher location
			if (this instanceof NonPlayerShip) {
				((NonPlayerShip) this).moveML();
			}
			
			// If this is a PlayerShip, we need to update our SteerableMissileLauncher's location as well.
			if (this instanceof PlayerShip) {
				((PlayerShip) this).moveML();
			}
		}
	}
}