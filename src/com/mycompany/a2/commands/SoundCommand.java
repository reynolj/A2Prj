package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.Game;
import com.mycompany.a2.GameWorld;

public class SoundCommand extends Command {
	private GameWorld gw;
	private Game g;

	/**
	 * Constructor
	 * @param gw GameWorld object
	 */
	public SoundCommand(Game g, GameWorld gw) {
		super("Sound On");
		this.gw = gw;
		this.g = g;
	}
	
	/**
	 * Override action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean soundOn = gw.toggleSound();
		g.setBGMusic(soundOn);
	}
}
