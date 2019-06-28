package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class NonPlayerShip extends Ship{
	private MissileLauncher missileLauncher;
	private int size;
	
	/**
	 * NonPlayerShip constructor.
	 * Sets default attributes such as location and direction. Sets the color, size and missile count.
	 */
	public NonPlayerShip() {
		super();
		this.setColor(ColorUtil.rgb(255,0,0));
		this.size = R.nextInt(2) % 2 == 0 ? NPS_SMALL : NPS_BIG;
		this.setMissileCount(INIT_M_NPS);
		// Create a missile launcher and set it's location, direction and speed
		// according to the location, direction and speed of the NPS.
		this.missileLauncher = new MissileLauncher();
		this.missileLauncher.setLocation(this.getLocation().getX(),this.getLocation().getY());
		this.missileLauncher.setDirection(this.getDirection());
		this.missileLauncher.setSpeed(this.getSpeed());
	}
	
	/**
	 * Sets the SteerableMissileLauncher's new location after move.
	 */
	public void moveML() {
		missileLauncher.setLocation(this.getLocation().getX(), this.getLocation().getY());
	}
	
	/**
	 * toString override method
	 */
	public String toString() {
		String parentDesc = super.toString();
		String localDesc = " size = " + this.size;
		String header = "NPS: "; 
		
		return header + parentDesc + localDesc;
	}
	
	@Override
	public void draw(Graphics g, Point2D p) {
		int height = this.size + 30; 
		int width = (this.size /2) + 30 ; 
		int originX = (int) (this.getLocation().getX() + p.getX() - width/2); 
		int originY = (int) (this.getLocation().getY() + p.getY() - height/2);
		
		g.setColor(this.getColor());
		g.fillArc(	originX, 
					originY, 
					width, 
					height, 
					180, 
					180);
		g.setColor(ColorUtil.rgb(192, 0, 0));
		g.fillArc(	originX, 
					originY - (height/4) + 1, 
					width, 
					height, 
					200, 
					140);
		
		this.missileLauncher.draw(g, p);
	}
}
