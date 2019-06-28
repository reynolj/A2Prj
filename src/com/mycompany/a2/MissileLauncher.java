package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class MissileLauncher extends MoveableGameObject{

	/**
	 * MissileLauncher constructor.
	 * Calls Super to set default attributes like location and direction
	 */
	public MissileLauncher() {
		super();
	}

	/**
	 * toString override method
	 */
	public String toString() {
		String parentDesc = super.toString();
		
		return parentDesc;
	}
	
	public void draw(Graphics g, Point2D p) {
		int width = 6;
		int height = 20;
		int originX = (int) (this.getLocation().getX() + p.getX() - (width/2)); 
		int originY = (int) (this.getLocation().getY() + p.getY());
		g.setColor(ColorUtil.GRAY);
		g.fillRect(	originX, 
					originY, 
					width, 
					height);
		g.setColor(ColorUtil.BLACK);
		g.drawRect(	originX, 
					originY, 
					width, 
					height);
	}

}