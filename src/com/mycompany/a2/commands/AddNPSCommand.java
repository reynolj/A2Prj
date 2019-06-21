package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddNPSCommand extends Command {
	
	/**
	 * Constructor
	 * @param gw is the GameWorld object
	 */
	private GameWorld gw;
	
	public AddNPSCommand(GameWorld gw) {
		super("Add Enemy Ship");
		this.gw = gw;
	}
	
	/**
	 * Override the action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getKeyEvent() != -1) {
			gw.addNonPlayerShip();
		}
	}
}
