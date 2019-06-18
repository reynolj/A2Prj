package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.mycompany.a2.GameWorld;

public class DecreasePSSpeedCommand extends Command {
	private GameWorld gw;
	
	/**
	 * @param gw GameWorld object
	 */
	public DecreasePSSpeedCommand(GameWorld gw) {
		super("Decrease Speed");
		this.gw = gw;
		
	}
	
	/**
	 * Override action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.decreaseSpeed();
	}
}
