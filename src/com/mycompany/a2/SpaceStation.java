package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class SpaceStation extends FixedGameObject {
	private int blinkRate;
	
	/**
	 * SpaceStation constructor
	 * Gets default attributes from parent (location, ID#).
	 * Sets color and blinkRate.
	 */
	public SpaceStation() {
		super();
		this.setColor(ColorUtil.rgb(0,255,0));	  		   
		this.blinkRate = R.nextInt(MAX_RATE + 1);			  
	}
	
	/**
	 * toString override method
	 */
	public String toString() {
		String parentDesc = super.toString();
		String localDesc = " rate = " + this.blinkRate;
		String header = "Station: ";
			  
		return header + parentDesc + localDesc;
	}
}
