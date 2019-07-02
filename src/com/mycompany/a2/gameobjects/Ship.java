package com.mycompany.a2.gameobjects;

public abstract class Ship extends MoveableGameObject{
	private int missileCount;
	
	/**
	 * Ship constructor.
	 * Gets default attributes from parent constructors (location, direction, heading, etc)
	 * Sets missile count.
	 */
	public Ship() {
		super();
		this.missileCount = 0;
	}
	
	//*******************************Getter Methods******************************************//
	
	/**
	 * Returns missileCount
	 * @return missileCount int
	 */
	public int getMissiles() {
		return missileCount;
	}
	
	//*******************************End of Getter Methods***********************************//
	
	//*******************************Setter Methods******************************************//
	
	/**
	 * Sets missile count
	 * @param count
	 */
	public void setMissileCount(int count) {
		this.missileCount = count;
	}
	
	//*******************************End of Setter Methods***********************************//
	
	/**
	 * Decrements missile count of the ship
	 */
	public void decrementMissileCount() {
		--this.missileCount;
	}
	
	/**
	 * toString override method
	 */
	@Override
	public String toString() {
		String parentDesc = super.toString();
		String localDesc = " missiles: " + missileCount;
		
		return parentDesc + localDesc;
	}
}