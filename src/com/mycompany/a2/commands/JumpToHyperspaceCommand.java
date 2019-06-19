package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class JumpToHyperspaceCommand extends Command {
	private GameWorld gw;
	
	/**
	 * Constructor
	 * @param gw GameWorld object
	 */
	public JumpToHyperspaceCommand (GameWorld gw){
		super("Jump To Hyperspace");
		this.gw = gw;
	}
	
	/**
	 * Override increase speed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getKeyEvent() != -1) {
			gw.hyperSpaceJump();
		}
	}
}