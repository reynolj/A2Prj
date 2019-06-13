package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Asteroid extends MoveableGameObject{
	private int size;
	
	/**
	 * Asteroid constructor.
	 * Sets all attributes to the default values (location, direction, color, etc) and updates the color and size.
	 */
	public Asteroid() {
		super();
		this.setColor(ColorUtil.rgb(255,255,0));
		this.size = R.nextInt(MAX_A_SIZE - MIN_A_SIZE + 1) + MIN_A_SIZE;
	}
	
	/**
	 * toString override method
	 */
	public String toString() {
		String parentDesc = super.toString();
		String localDesc = " size = " + this.size;
		String header = "Asteroid: ";
		
		return header + parentDesc + localDesc;
	}

}