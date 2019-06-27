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
		int noseDir = this.getDirection();
		int height = this.size + 15; 
		int width = (this.size /2) + 15 ; 
		int originX = (int) (this.getLocation().getX() + p.getX() - width/2); 
		int originY = (int) (this.getLocation().getY() + p.getY() - height/2);
		
		g.setColor(this.getColor());
		g.fillArc(originX, originY, width, height, 0, 180);
		g.setColor(ColorUtil.WHITE);
		g.fillArc((originX), (originY + ((height/4)) + 1), width, height/2, 0, 180);
	}
}
