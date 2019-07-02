package com.mycompany.a2.gameobjects;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.interfaces.IDrawable;
import com.mycompany.a2.interfaces.IGameObject;
import com.codename1.charts.util.ColorUtil;
import java.lang.Math;
import java.util.Random;

public abstract class GameObject implements IGameObject, IDrawable{
	protected final static Random R = new Random();
	private Point2D location;
	private int color;
	
	/**
	 * GameObject constructor.
	 * Defines default location (random x and y) and color for all game objects.
	 */
	public GameObject() {
		this.location = new Point2D(GameWorld.getWidth() * R.nextDouble(), GameWorld.getHeight() * R.nextDouble());
		this.color = ColorUtil.rgb(0, 0, 0);
	}
	
	//*******************************Getter Methods******************************************//
	
	/**
	 * Returns the color in a ColorUtil format
	 * @return color (ColorUtil)
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Returns the color in a more human readable format
	 * @return color (separated r g b values)
	 */
	public String getColorRGB() {
		String ret = "[" + ColorUtil.red(this.color) + 
					 "," + ColorUtil.green(this.color) +
					 "," + ColorUtil.blue(this.color) +
					 "]";
		return ret;
	}
	
	/**
	 * Returns the location of the GameObject
	 * @return location (Point2D)
	 */
	public Point2D getLocation() {
		return location;
	}
	
	/**
	 * Returns the location of the GameOject in a more human readable format (used for output)
	 * @return a string representation of the GameObject location
	 */
	public String getLocationText() {
		String ret = "";
		ret += Math.round( location.getX() * 10.0)/10.0
				+ ","
				+ Math.round( location.getY() * 10.0)/10.0;
		
		return ret;
	}
	
	//*******************************End of Getter Methods***********************************//
	
	//*******************************Setter Methods******************************************//
	/**
	 * Sets the location for the new GameObject (random x and y)
	 * @param x
	 * @param y
	 */
	public void setLocation(double x, double y) {
		location = new Point2D(x,y);
	}
	
	/**
	 * Sets the color for all GameObjects to a default black (updated in the concrete object)
	 * @param _color
	 */
	public void setColor(int _color) {
		color = _color;
	}
	
	//*******************************End of Setter Methods***********************************//

	/* (non-Javadoc)
	 * @see com.mycompany.a2.interfaces.IDrawable#draw(com.codename1.ui.Graphics, com.codename1.ui.geom.Point2D)
	 */
	public void draw(Graphics g, Point2D p) {
		g.setColor(this.color);
		g.drawRect( (int) ((this.getLocation().getX() - 5) + p.getX()), 
					(int) ((this.getLocation().getY() - 5) + p.getY()), 
					10, 
					10);
	}
	
	/**
	 * toString override method
	 */
	@Override
	public String toString() {
		String ret = "loc = " + this.getLocationText() + 
				  " color = " + this.getColorRGB(); 
		return ret;
	}
}