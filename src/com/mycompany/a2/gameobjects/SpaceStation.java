package com.mycompany.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

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
		this.setColor(ColorUtil.GRAY);	  		   
		this.blinkRate = R.nextInt(MAX_RATE + 1);
		this.lightOn = true;
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
	
	@Override
	public void draw(Graphics g, Point2D p) {
		int originX = (int) (this.getLocation().getX() + p.getX());
		int originY = (int) (this.getLocation().getY() + p.getY());
		
		int shipHeight  = 64;
		int shipWidth   = 80;
		
		int lightDiameter = 32;
		int lightRadius = lightDiameter/2;

		int shipX = originX - shipWidth/2;
		int shipY = originY;
		int lightX = originX - lightRadius;
		int lightY = originY + lightRadius;
		
		g.setColor(this.getColor());
		
		//Top arc
		g.fillArc(shipX,
				  shipY,
				  shipWidth,
				  shipHeight,
				  0,
				  180
				);

		//Bottom arc
		g.fillArc(shipX,
				  shipY,
				  shipWidth,
				  shipHeight,
				  0,
				  -180
				);
		
		//Blinking light
		g.setColor(ColorUtil.YELLOW);
		if (this.lightOn == true) {
			g.setColor(ColorUtil.YELLOW);
			g.fillArc(lightX,
					  lightY,
					  lightDiameter,
					  lightDiameter,
					  0,
					  360
					);
		} else {
			g.drawArc(lightX,
					  lightY,
					  lightDiameter,
					  lightDiameter,
					  0,
					  360
					);
		}
	}
	
	/**
	 * toString override method
	 */
	@Override
	public String toString() {
		String parentDesc = super.toString();
		String localDesc = " rate = " + this.blinkRate + " light is " + ((this.lightOn == true) ? "on" : "off");
		String header = "Station: ";
			  
		return header + parentDesc + localDesc;
	}
}