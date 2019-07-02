package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class Collision_Asteroid_NPS_Command extends Command {
	private GameWorld gw;
	
	/**
	 * Constructor
	 * @param gw GameWorld object
	 */
	public Collision_Asteroid_NPS_Command(GameWorld gw) {
		super("Kill Asteroid with NPS");
		this.gw = gw;
	}
	
	/**
	 * Override action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.collision_Asteroid_NPS();
	}
}