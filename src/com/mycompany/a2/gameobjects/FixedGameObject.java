package com.mycompany.a2.gameobjects;

public abstract class FixedGameObject extends GameObject {
	private static int ID = 0;

	/**
	 * FixedGameObject Constructor.
	 * Sets all attributes to the default values (location, color) sets object ID 
	 */
	public FixedGameObject() {
		super();
		ID++;
	}
	
	/**
	 * @return object ID (use for space stations)
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * toString override method
	 */
	public String toString() {
		String parentDesc = super.toString();
		
		return parentDesc;
	}
}