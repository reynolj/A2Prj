package com.mycompany.a2.gameobjects;

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
		int height = 30;
		int originX = (int) (this.getLocation().getX() + p.getX() - (width/2)); 
		int originY = (int) (this.getLocation().getY() + p.getY());
		
		int x = (int) (p.getX() + this.getLocation().getX());
		int y = (int) (p.getY() + this.getLocation().getY());
		
		g.setColor(ColorUtil.GREEN);
		g.fillArc(x-5, y-5, 10, 10, 0, 360);
		g.setColor(ColorUtil.CYAN);
		g.drawArc(x-5, y-5, 10, 10, 0, 360);
		
		g.setColor(ColorUtil.GRAY);		
		double angle = Math.toRadians(90-this.getDirection());
		double deltaX = Math.cos(angle);
		double deltaY = Math.sin(angle);
		g.drawLine(x, y, (int)(x+(20*deltaX)), (int)(y+(20*deltaY)));
		
		
		// Our old missile launcher
		/*
		// Draw the barrel (lighter gray)
		g.setColor(ColorUtil.GRAY);
		g.fillRect(	originX, 
					originY, 
					width, 
					height);
		// Draw the barrel's dark outline (black)
		g.setColor(ColorUtil.BLACK);
		g.drawRect(	originX, 
					originY, 
					width, 
					height);
		// Draw the turret (darker gray)
		g.setColor(ColorUtil.rgb(64, 64, 64));
		g.fillArc(	(int) (this.getLocation().getX() + p.getX() - 6 ), 
					(int) (this.getLocation().getY() + p.getY() - 6 ), 
					12, 
					12, 
					0, 
					360);
		// Draw the turret's outline (lighter gray)
		g.setColor(ColorUtil.GRAY);
		g.drawArc(	(int) (this.getLocation().getX() + p.getX() - 6 ),
					(int) (this.getLocation().getY() + p.getY() - 6 ), 
					12, 
					12, 
					315, 
					270);
		*/
	}

}