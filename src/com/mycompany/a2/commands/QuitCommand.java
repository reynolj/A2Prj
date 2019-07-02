package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class QuitCommand extends Command {
private GameWorld gw;
	
	/**
	 * Constructor
	 * @param gw GameWorld object
	 */
	public QuitCommand(GameWorld gw) {
		super("Quit Game");
		this.gw = gw;
	}
	
	/**
	 * Override action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.quit();
	}
}