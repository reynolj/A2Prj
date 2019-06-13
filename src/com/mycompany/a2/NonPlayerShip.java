package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

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
	
}
