package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class Asteroid extends MoveableGameObject{
	private int size;
	
	/**
	 * Asteroid constructor.
	 * Sets all attributes to the default values (location, direction, color, etc) and updates the color and size.
	 */
	public Asteroid() {
		super();
		this.setColor(ColorUtil.rgb(89,48,1));
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
	
	public void draw(Graphics g, Point2D p) {
		int height  =  this.size + 15;
		int width   =  this.size + 15;
		int originX = (int) (this.getLocation().getX() + p.getX() - width/2);
		int originY = (int) (this.getLocation().getY() + p.getY() - height/2);
		
		g.setColor(this.getColor());
		g.fillArc( originX,
				   originY, 
				   width,
				   height,
				   0, 
				   360);
	}
}