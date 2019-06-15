package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class SpaceStation extends FixedGameObject {
	private int blinkRate;
	private boolean lightOn;
	
	/**
	 * SpaceStation constructor
	 * Gets default attributes from parent (location, ID#).
	 * Sets color and blinkRate.
	 */
	public SpaceStation() {
		super();
		this.setColor(ColorUtil.rgb(0,255,0));	  		   
		this.blinkRate = R.nextInt(MAX_RATE + 1);
		this.lightOn = true;
	}
	
	/**
	 * toString override method
	 */
	public String toString() {
		String parentDesc = super.toString();
		String localDesc = " rate = " + this.blinkRate + " light is " + ((this.lightOn == true) ? "on" : "off");
		String header = "Station: ";
			  
		return header + parentDesc + localDesc;
	}

	/**
	 * Toggle the light
	 * If the light is on, turn it off and vis-versa.
	 */
	public void toggleLight() {
		this.lightOn = !this.lightOn;
	}

	/**
	 * @return the blink rate of this SpaceStation
	 */
	public int getBlinkRate() {
		return this.blinkRate;
	}
}