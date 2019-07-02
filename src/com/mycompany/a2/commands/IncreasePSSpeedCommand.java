package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class IncreasePSSpeedCommand extends Command {
	private GameWorld gw;
	
	/**
	 * Constructor
	 * @param gw GameWorld object
	 */
	public IncreasePSSpeedCommand (GameWorld gw){
		super("Increase Speed");
		this.gw = gw;
	}
	
	/**
	 * Override increase speed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.increaseSpeed();
	}
}