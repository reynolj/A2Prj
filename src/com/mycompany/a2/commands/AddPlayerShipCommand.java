package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddPlayerShipCommand extends Command {
	private GameWorld gw;
	
	/**
	 * Constructor
	 * @param gw GameWorld object
	 */
	public AddPlayerShipCommand(GameWorld gw) {
		super("Add Player Ship");
		this.gw = gw;
	}
	
	/**
	 * Override action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getKeyEvent() != -1) {
			gw.addPlayerShip();
		}
	}
}