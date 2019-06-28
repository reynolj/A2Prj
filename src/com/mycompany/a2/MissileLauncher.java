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
		int height = 30;
		int originX = (int) (this.getLocation().getX() + p.getX() - (width/2)); 
		int originY = (int) (this.getLocation().getY() + p.getY());
		
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
	}

}