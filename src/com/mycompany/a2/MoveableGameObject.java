package com.mycompany.a2;

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
	
	/**
	 * Sets the speed of the MoveableObject
	 * @param _speed
	 */
	public void setSpeed(int _speed) {
		speed = _speed;
	}
	
	/**
	 * Sets the direction of the MoveableObject
	 * @param _direction
	 */
	public void setDirection(int _direction) {
		direction = _direction;
	}
	
	/**
	 * Returns the speed of the MoveableObject
	 * @return speed (int)
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Returns the direction of the MoveableObject
	 * @return direction (int 0-359)
	 */
	public int getDirection() {
		return direction;
	}
	
	/**
	 * toString override method
	 */
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
	public void move() {
		if (this instanceof SteerableMissileLauncher) {
			//Don't move the SteerableMissileLauncher directly.
			//It's direction is not the direction of movement.
			//It's movement is based on the movement of PlayerShip.
			//PlayerShip will update the location of SteerableMissileLauncher.
		} else {
			int myDirection = (90 - (this.getDirection()));	// gets the true degrees using proper math representation.
			double newX = this.getLocation().getX() + Math.cos((Math.toRadians(myDirection))) * this.getSpeed();
			double newY = this.getLocation().getY() + Math.sin((Math.toRadians(myDirection))) * this.getSpeed();
			newX = (newX + MAX_X) % MAX_X;					// using mod to have object pop up on the other side of the game board.
			newY = (newY + MAX_Y) % MAX_Y;					// using mod to have object pop up on the other side of the game board.
			this.setLocation(newX, newY);
			
			// If this is a PlayerShip, we need to update our SteerableMissileLauncher's location as well.
			if (this instanceof PlayerShip) {
				((PlayerShip) this).setMLLocation();
			}
			
			// If this is a Missile, we need to decrement the fuel left.
			if (this instanceof Missile) {
				((Missile) this).useFuel();
			}
		}
	}
}